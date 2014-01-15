package app.seamolec.halodeutsch;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class AudioPlayer implements OnClickListener, Runnable {

	static MediaPlayer mp;
	Button btn1;
	SeekBar sb1;
	Activity act;
	String fileLoc;

	AudioPlayer(Activity act, Button btn1, SeekBar sb1, String fileLoc) {
		this.act = act;
		this.btn1 = btn1;
		this.sb1 = sb1;
		this.fileLoc = fileLoc;
	}

	public void run() {
		updatePosition(mp);
	}

	public void updatePosition(MediaPlayer mp) {
		sb1.setProgress(mp.getCurrentPosition());
		if (mp.isPlaying()) {
			Runnable notification = new Thread(this);
			new Handler().postDelayed(notification, 100);
		} else {
			mp.pause();
			btn1.setBackgroundResource(R.drawable.play);
			sb1.setProgress(0);
		}
	}

	@Override
	public void onClick(View v) {
		System.gc();
		if (mp == null || !mp.isPlaying()) {
			mp = new MediaPlayer();
			try {
				AssetFileDescriptor descriptor = act.getAssets()
						.openFd(fileLoc);
				mp.setDataSource(descriptor.getFileDescriptor(),
						descriptor.getStartOffset(), descriptor.getLength());
				descriptor.close();
				mp.prepare();
				sb1.setMax(mp.getDuration());
				mp.start();
				sb1.setProgress(mp.getCurrentPosition());
				updatePosition(mp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			btn1.setBackgroundResource(R.drawable.stop);
		} else {
			mp.pause();
			btn1.setBackgroundResource(R.drawable.play);
			sb1.setProgress(0);
		}
	}

}

package app.seamolec.halodeutsch;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.SumPathEffect;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Quiz2 extends Activity implements OnCheckedChangeListener{
	
	String mappingA1[]={"1","0","1","1","0"};
	int mappingA2[]=new int[5];
	
	Context context=this;
	Activity activity=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		  super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz2);
		LinearLayout ll = (LinearLayout)findViewById(R.id.scroll_view_co);
		
		for (int j = 0; j < 5; j++) {
			createQAType1(ll, j, j+1);
		}
		
		
		
		Button bsubmit= new Button(this);
		bsubmit.setText("Ok");
		bsubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.quiz2_score);
				
				TextView score=(TextView)findViewById(R.id.score);

				ImageButton button=(ImageButton)findViewById(R.id.btnback);
				button.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if(arg0.getId() == R.id.btnback){
							Intent i=new Intent(Quiz2.this, Quiz3.class);
							startActivity(i); 
							finish();
							}
						// TODO Auto-generated method stub
						
					}});
				
				int hasil = 0;
				for(int i : mappingA2){
					hasil+=i;
				}
				score.setText(""+(hasil*20));
			}
		});
		ll.addView(bsubmit);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		Log.i("Chck - ", "" + arg0.getId());
		int id4 = arg0.getCheckedRadioButtonId();
		Log.i("Chck id - ", "" + id4);

		RadioButton radioButton4 = (RadioButton) arg0.findViewById(id4);
		Log.i("Chck fx - ", "" + radioButton4.getText().toString());
		
		int val1=radioButton4.getText().toString().equals("Falsch")?1:0;
		mappingA2[arg0.getId()]=mappingA1[arg0.getId()].equals(""+val1)?1:0;	

	}
	public void createQAType1(LinearLayout ll, String fileLoc){
		LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View view = inflate.inflate(R.layout.quiz2_layout_intro, null);
		
		final SeekBar sb1=(SeekBar)view.findViewById(R.id.co_seekbar);
		sb1.setEnabled(false);   			
		final Button btn1=(Button)view.findViewById(R.id.co_bplay);		
		AudioPlayer pa=new AudioPlayer(this,btn1,sb1, fileLoc);
		btn1.setOnClickListener(pa);
		ll.addView(view);
	}
	
	public void createQAType1(LinearLayout ll, final int qnum, int number){
		LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View view = inflate.inflate(R.layout.quiz2_layout_list, null);

		TextView tv1=(TextView)  view.findViewById(R.id.co_number);
		tv1.setText(""+number+". ");
		ImageView im1=(ImageView)view.findViewById(R.id.co_imv);		
		try {
			im1.setImageDrawable(Drawable.createFromStream(getAssets().open("qa/co1/question2_"+(qnum+1)+".png"), null));
		} catch (IOException e) {
			e.printStackTrace();
		}
		final SeekBar sb1=(SeekBar)view.findViewById(R.id.co_seekbar);
		sb1.setEnabled(false);   	
		
		final Button btn1=(Button)view.findViewById(R.id.co_bplay);		
		AudioPlayer pa=new AudioPlayer(this,btn1,sb1,"qa/co1sound/question2_"+(qnum+1)+".mp3");
		btn1.setOnClickListener(pa);
		RadioGroup rg = (RadioGroup) view.findViewById(R.id.co_choice);
		rg.setId(qnum);
		rg.setOnCheckedChangeListener(this);
		ll.addView(view);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if( AudioPlayer.mp != null)
			AudioPlayer.mp.stop();
	}
}

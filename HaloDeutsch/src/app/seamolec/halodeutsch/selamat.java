package app.seamolec.halodeutsch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class selamat extends Activity {
    /** Called when the activity is first created. */
    

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  setContentView(R.layout.selamat);
      menu_animasi();
       

    
    		
    		
    		Button btnJawab1 = (Button) findViewById(R.id.btncreate);
    		btnJawab1.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				
    					Intent intent = new Intent(v.getContext(), Mainmenu.class);
    		            startActivity(intent);
    		            finish();
    				
    			}
    		});
    		
    		
    	}
    private void menu_animasi() {
    	Animation a = AnimationUtils.loadAnimation(this, R.anim.menu2);
        a.reset();
        ImageView tv = (ImageView) findViewById(R.id.imageView1);
        a.setDuration(900);
        tv.clearAnimation();
        tv.startAnimation(a);
        
        
        
	}

}
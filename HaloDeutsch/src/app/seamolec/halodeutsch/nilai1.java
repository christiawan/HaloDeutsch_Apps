package app.seamolec.halodeutsch;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class nilai1 extends Activity {
    /** Called when the activity is first created. */
	TextView nilai;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		  setContentView(R.layout.nilai1);
        
      nilai = (TextView) findViewById(R.id.nilai);

        Intent it = getIntent();
        String data = "Ihre Note : " + it.getStringExtra("nilai");
        nilai.setText(data);
       
       
        int nilai = Integer.parseInt(it.getStringExtra("nilai").toString());
		
       ImageButton b = (ImageButton) findViewById(R.id.wieder);
       b.setOnClickListener(new OnClickListener() {

    	   public void onClick(View v) {
    		   Intent it = getIntent();
    		// TODO Auto-generated method stub
    		   int nilai = Integer.parseInt(it.getStringExtra("nilai").toString());
    		
    		if(nilai > 50) {
    		        Intent intent = new Intent(v.getContext(), Quiz2.class);
    		        startActivity(intent);
    		        finish();
    		       
    		} 	else {
    		        Intent intent = new Intent(v.getContext(), Quiz1.class);
    		        startActivity(intent);
    		        finish();
    		}
    		}

        });     
     
    }
}
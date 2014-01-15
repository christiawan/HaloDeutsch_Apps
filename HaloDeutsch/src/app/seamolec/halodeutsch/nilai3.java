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

public class nilai3 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		   setContentView(R.layout.nilai3);
        
      TextView  etData = (TextView) findViewById(R.id.nilai);

        Intent it = getIntent();
        String data = "Ihre Note : \n" + it.getStringExtra("nilai");
       etData.setText(data);
       
       
      
       ImageButton c = (ImageButton) findViewById(R.id.next);
       c.setOnClickListener(new OnClickListener() {

         public void onClick(View v) {
         // TODO Auto-generated method stub
        	  Intent intent = new Intent(v.getContext(), selamat.class);
              startActivity(intent);
              finish();
         }
         });
    }
}
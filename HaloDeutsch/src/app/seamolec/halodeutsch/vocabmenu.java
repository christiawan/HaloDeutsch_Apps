package app.seamolec.halodeutsch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class vocabmenu extends Activity    implements OnClickListener {
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		  setContentView(R.layout.menuvocab);
		  
		  Button bzahlen=(Button)findViewById(R.id.btzahlen);
		  bzahlen.setOnClickListener(this);  
		  Button blibens=(Button)findViewById(R.id.btlibens);
		  blibens.setOnClickListener(this);
		  Button bschreib=(Button)findViewById(R.id.btschreib);
		  bschreib.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == R.id.btzahlen){
			Intent i=new Intent(this, vocab1.class);
			startActivity(i); }
		else if(arg0.getId() == R.id.btlibens){
			Intent i=new Intent(this, vocab2.class);
			startActivity(i); }
		else if(arg0.getId() == R.id.btschreib){
			Intent i=new Intent(this, vocab3.class);
			startActivity(i); }
	}
}

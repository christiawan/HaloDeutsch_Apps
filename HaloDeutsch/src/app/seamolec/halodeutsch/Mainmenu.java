package app.seamolec.halodeutsch;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Mainmenu extends Activity   implements OnClickListener {
	int mFlipping = 0 ;
	Dialog zowat;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  setContentView(R.layout.menu);
	
		   {
				ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper1);
				
				if(mFlipping==0){
					/** Start Flipping */
					flipper.startFlipping();
					mFlipping=1;
					
				}
				else{
					/** Stop Flipping */
					flipper.stopFlipping();					
					mFlipping=0;
					
				}
			}
		   
		  
			 Button bquiz=(Button)findViewById(R.id.btnquiz);
			 bquiz.setOnClickListener(this);
				 Button bcoba=(Button)findViewById(R.id.btnwort);
					bcoba.setOnClickListener(this);
					 Button binfo=(Button)findViewById(R.id.btninfo);
					 binfo.setOnClickListener(this);
					 Button btnZowat=(Button)findViewById(R.id.btnhelp);
		   
					 btnZowat.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View v) {
								Zowat();
								
							}
						});
					 Button bcreate=(Button)findViewById(R.id.btncreate);
					 bcreate.setOnClickListener(this);
					 }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btnquiz){
			Intent i=new Intent(this, Quiz1.class);
			startActivity(i); }
		else if(v.getId() == R.id.btnwort){
			Intent i=new Intent(this, vocabmenu.class);
			startActivity(i); }
		else if(v.getId() == R.id.btninfo){
			Intent i=new Intent(this, InfoTab.class);
			startActivity(i); }
		else if(v.getId() == R.id.btncreate){
			Intent i=new Intent(this, CreateTab.class);
			startActivity(i); }
	}

	public void Zowat(){
		zowat  = new Dialog(Mainmenu.this,android.R.style.Theme_Translucent);
		zowat.requestWindowFeature(Window.FEATURE_NO_TITLE);
	zowat.setCancelable(true);
	zowat.setContentView(R.layout.help);
	Button btnclose = (Button)zowat.findViewById(R.id.btnclosezowat);
	btnclose.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		zowat.dismiss();	
		}
	});
	zowat.show();
	}
	

}

package app.seamolec.halodeutsch;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Loading extends Activity {
	  
	   private static int progress = 10;
	   private int status = 0;
	   ProgressBar progressBar;
	   Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  setContentView(R.layout.loading);
		  
		  progressBar = (ProgressBar) findViewById(R.id.progg);
	      
	      
		  new Thread(new Runnable() {
		         
		         @Override
		         public void run() {
		            // TODO Auto-generated method stub
		            while(status < 100){
		               status = loading();
		               handler.post(new Runnable() {
		                  
		                  @Override
		                  public void run() {
		                     // TODO Auto-generated method stub
		                  progressBar.setProgress(status);   
		                  }
		               });
		               
		            }
		            handler.post(new Runnable() {
		               @Override
		               public void run() {
		                  // TODO Auto-generated method stub
		                  Intent inten = new Intent(Loading.this, Mainmenu.class);
		                  Loading.this.startActivity(inten);
		                  Loading.this.finish();
		               }
		            });
		         }
		         
		         public int loading(){
		            try{
		               Thread.sleep(20);
		            }catch(InterruptedException ie){
		               ie.printStackTrace();
		            }
		            return ++progress;
		         }
		      }).start();
		   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loading, menu);
		return true;
	}

}

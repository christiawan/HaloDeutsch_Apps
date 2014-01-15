package app.seamolec.halodeutsch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class Quiz3 extends Activity {
	  public int a=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 setContentView(R.layout.quiz3);
		
		final EditText text1 = (EditText)findViewById(R.id.satu);
		final EditText text2 = (EditText)findViewById(R.id.dua);
		final EditText text3 = (EditText)findViewById(R.id.tiga);
		final EditText text4 = (EditText)findViewById(R.id.empat);
		final EditText text5 = (EditText)findViewById(R.id.lima);
		
		Button btnJawab1 = (Button) findViewById(R.id.ok);
		btnJawab1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(text1.getText().toString().equals("Reis")){
					a=a+20;
				}
				if(text1.getText().toString().equals("reis")){
					a=a+10;
				}
				if(text2.getText().toString().equals("im Restaurant")){
					a=a+20;
				}
				if(text2.getText().toString().equals("im restaurant")){
					a=a+10;
				}
				if(text3.getText().toString().equals("Bücher und Hefte")){
					a=a+20;
				}
				if(text3.getText().toString().equals("bucher und hefte")){
					a=a+10;
				}
				if(text4.getText().toString().equals("Kugelschreiber")){
					a=a+20;
				}

				if(text4.getText().toString().equals("kugelschreiber")){
					a=a+10;
				}
				if(text5.getText().toString().equals("Radiergummi")){
					a=a+20;
				}

				if(text5.getText().toString().equals("radiergummi")){
					a=a+10;
				}
				
				else{
					a=a+0;
				}
			
				String s = Integer.toString(a);
					Intent intent = new Intent(v.getContext(), nilai3.class);
					intent.putExtra("nilai", s);
		            startActivity(intent);
		            finish();
				
			
				
				
				
				
	          
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loading, menu);
		return true;
	}

}

package app.seamolec.halodeutsch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz1 extends Activity{
	private RadioButton satua;
	private RadioButton satub;
	private RadioButton satuc;	
	private RadioButton satud;
	private RadioButton duaa;
	private RadioButton duab;
	private RadioButton duac;
	private RadioButton duad;
	private RadioButton tigaa;
	private RadioButton tigab;
	private RadioButton tigac;
	private RadioButton tigad;
	private RadioButton empata;
	private RadioButton empatb;
	private RadioButton empatc;
	private RadioButton empatd;
	private RadioButton limaa;
	private RadioButton limab;
	private RadioButton limac;
	private RadioButton limad;
	public int a=0;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		  setContentView(R.layout.quiz1);

		satua = (RadioButton) findViewById(R.id.satua);
		satub = (RadioButton) findViewById(R.id.satub);
		satuc = (RadioButton) findViewById(R.id.satuc);
		satud = (RadioButton) findViewById(R.id.satud);
		duaa = (RadioButton) findViewById(R.id.duaa);
		duab = (RadioButton) findViewById(R.id.duab);
		duac = (RadioButton) findViewById(R.id.duac);
		duad = (RadioButton) findViewById(R.id.duad);
		tigaa = (RadioButton) findViewById(R.id.tigaa);
		tigab = (RadioButton) findViewById(R.id.tigab);
		tigac = (RadioButton) findViewById(R.id.tigac);
		tigad = (RadioButton) findViewById(R.id.tigad);
		empata = (RadioButton) findViewById(R.id.empata);
		empatb = (RadioButton) findViewById(R.id.empatb);
		empatc = (RadioButton) findViewById(R.id.empatc);
		empatd = (RadioButton) findViewById(R.id.empatd);
		limaa = (RadioButton) findViewById(R.id.limaa);
		limab = (RadioButton) findViewById(R.id.limab);
		limac = (RadioButton) findViewById(R.id.limac);
		limad = (RadioButton) findViewById(R.id.limad);
		
		Button btnJawab1 = (Button) findViewById(R.id.OK);
		btnJawab1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (satub.isChecked()){
					a=a+20;
				}
				if (duab.isChecked()){
					a=a+20;
				}
				if (tigaa.isChecked()){
					a=a+20;
				}
				if (empatc.isChecked()){
					a=a+20;
				}
				if (limad.isChecked()){
					a=a+20;
				}
				else{
					a=a+0;
				}
			
				String s = Integer.toString(a);
				
				Intent intent = new Intent(v.getContext(), nilai1.class);
	            intent.putExtra("nilai", s);
	            finish();
	            startActivity(intent);
	          
				
			}
		});
		
	
	}
}

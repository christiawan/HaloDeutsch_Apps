package app.seamolec.halodeutsch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class vocab2 extends Activity {
	private static final int REQ_TTS_STATUS_CHECK = 0;
	private static final String TAG = "TTS";
    private TextToSpeech mTts;
    ListView list;
	
	// Array of strings storing country names
    String[] countries = new String[] {
            "bleistift",
            "buchhandlung",
            "computer",
            "fueller",
            "heft",
            "kreide",
            "kuli",
            "papier",
            "radiergummi",
            "schwamm"
    };
    
    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
    		R.drawable.schreibbleistift,
    		R.drawable.schreibbuchhandlung,
    		R.drawable.schreibcomputer,
    		R.drawable.schreibfueller,
    		R.drawable.schreibheft,
    		R.drawable.schreibkreide,
    		R.drawable.schreibkuli,
    		R.drawable.schreibpapier,
    		R.drawable.schreibradiergummi,
    		R.drawable.schreibschwamm
    };
	
    // Array of strings to store currencies
    String[] currency = new String[]{
    	" ",
    	" ",
    	" ",
    	" ",
    	" ",
    	" ",
    	" ",
    	" ",
    	" ",
    	" "
    };
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		  super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        list = (ListView) findViewById(R.id.listV_main);
        list.setOnItemClickListener(speak);
		Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, REQ_TTS_STATUS_CHECK);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<10;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("cur", currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );            
            aList.add(hm);        
        }
        
        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };
        
        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};        
        
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout_vocab2, from, to);
        
        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listV_main);
        
        // Setting the adapter to the listView
        listView.setAdapter(adapter);  
    }
        
        // Item Click Listener for the listview
        public void doSpeak(View view) {
    		
    	};
    	
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQ_TTS_STATUS_CHECK) {
                switch (resultCode) {
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    // TTS is up and running
                    mTts = new TextToSpeech(this, null);
                    Log.v(TAG, "Pico is installed okay");
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_BAD_DATA:
                case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_DATA:
                case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_VOLUME:
                    // missing data, install it
                    Log.v(TAG, "Need language stuff: " + resultCode);
                    Intent installIntent = new Intent();
                    installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                    startActivity(installIntent);
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                default:
                    Log.e(TAG, "Got a failure. TTS apparently not available");
                }
            }
            else {
            	// Got something else
            }
        }

    	public void onInit(int status) {
    		// Now that the TTS engine is ready, we enable the button
    		if( status == TextToSpeech.SUCCESS) {
    			 //submit.setEnabled(true);
    			 mTts.setPitch(0.6f);
    		}
    	}
    	

    	@Override
    	public void onPause()
    	{
    		super.onPause();
    		// if we're losing focus, stop talking
    		if( mTts != null)
    			mTts.stop();
    	}

    	@Override
        public void onDestroy()
    	{
            super.onDestroy();
            mTts.shutdown();
        }
    	private  OnItemClickListener speak  = new  OnItemClickListener() {
    		public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
        		// Getting the Container Layout of the ListView
        		LinearLayout linearLayoutParent = (LinearLayout) container;
        		
        		// Getting the inner Linear Layout
        		LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);
        		
        		// Getting the Country TextView
        		TextView tvCountry = (TextView) linearLayoutChild.getChildAt(0);
        		
        		 mTts.setLanguage(Locale.GERMAN);
		            Toast.makeText(getApplication(), tvCountry.getText().toString(), Toast.LENGTH_LONG).show();
		            mTts.speak(tvCountry.getText().toString(), TextToSpeech.QUEUE_ADD, null);

    		}

    		};
    	
    }
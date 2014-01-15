package app.seamolec.halodeutsch;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
public class InfoTab extends TabActivity {
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
	
	
	 requestWindowFeature(Window.FEATURE_NO_TITLE);
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	 
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.listview_tab_info);
  Resources res = getResources(); // Resource object to get Drawables
  TabHost tabHost = getTabHost(); // The activity TabHost
  TabHost.TabSpec spec; // Reusable TabSpec for each tab
  Intent intent; // Reusable Intent for each tab

  // Create an Intent to launch an Activity for the tab (to be reused)
  intent = new Intent().setClass(this, infomagis.class);
  spec = tabHost.newTabSpec("magis")
    .setIndicator("", res.getDrawable(R.drawable.tab_magis))
    .setContent(intent);
  tabHost.addTab(spec);

  // Do the same for the other tabs

  intent = new Intent().setClass(this, infoseamolec.class);
  spec = tabHost.newTabSpec("semolec")
    .setIndicator("", res.getDrawable(R.drawable.tab_seamolec))
    .setContent(intent);
  tabHost.addTab(spec);
  

  intent = new Intent().setClass(this, infogothe.class);
  spec = tabHost.newTabSpec("gothe")
    .setIndicator("", res.getDrawable(R.drawable.tab_gothe))
    .setContent(intent);
  tabHost.addTab(spec);
  
  
  //set tab which one you want open first time 0 or 1 or 2
  tabHost.setCurrentTab(0);
  
  
 }
 
}
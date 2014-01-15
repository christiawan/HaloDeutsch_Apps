package app.seamolec.halodeutsch;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

public class vocabTab extends TabActivity {
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  requestWindowFeature(Window.FEATURE_NO_TITLE);
  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
 
  setContentView(R.layout.listview_tab_vocab);
 
  Resources res = getResources(); // Resource object to get Drawables
  TabHost tabHost = getTabHost(); // The activity TabHost
  TabHost.TabSpec spec; // Reusable TabSpec for each tab
  Intent intent; // Reusable Intent for each tab

  // Create an Intent to launch an Activity for the tab (to be reused)
  intent = new Intent().setClass(this, vocab1.class);
  spec = tabHost.newTabSpec("Zahlen")
    .setIndicator("Zahlen", res.getDrawable(R.drawable.ic_tab_zahlen))
    .setContent(intent);
  tabHost.addTab(spec);

  // Do the same for the other tabs

  intent = new Intent().setClass(this, vocab2.class);
  spec = tabHost.newTabSpec("Schreibwaren")
    .setIndicator("Schreibwaren", res.getDrawable(R.drawable.ic_tab_book))
    .setContent(intent);
  tabHost.addTab(spec);
  
  
  intent = new Intent().setClass(this, vocab3.class);
  spec = tabHost
    .newTabSpec("Liensmittel")
    .setIndicator("Liensmittel", res.getDrawable(R.drawable.ic_tab_eat))
    .setContent(intent);
  tabHost.addTab(spec);
  
  //set tab which one you want open first time 0 or 1 or 2
  tabHost.setCurrentTab(0);
  
  
 }
 
}
package com.elijahsh.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import com.elijahsh.view.ListViewMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
	

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ListViewMenu navigationMenu = (ListViewMenu) findViewById(R.id.navigation_menu);
		    MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.mnu_navigation, navigationMenu);
		    navigationMenu.setMenuClickListener(new ListViewMenu.OnMenuClickListener() {
		        @Override
		        public void onClick(MenuItem menuItem) {
		            // Standard menu click handler
		        }
		    });
    }
}

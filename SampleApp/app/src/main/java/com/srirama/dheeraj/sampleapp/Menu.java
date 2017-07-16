package com.srirama.dheeraj.sampleapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by DHEERAJ on 05-06-2017.
 */
public class Menu extends ListActivity{
    String classes[] ={"startingPoint","TextPlay","Camera","Data","GFX","GFXSurface",
            "Soundstuff","slider","Tabs","SampleBrowser","flipper","Sharedprefs","InternalData","ExternalData","SQLite","Accelerate"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }
        @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

            super.onListItemClick(l, v, position, id);
            String cheese = classes[position];                    //adding class to  list menu
            try {
                Class ourClass = Class.forName("com.srirama.dheeraj.sampleapp."+ cheese);
                Intent ourIntent = new Intent(Menu.this, ourClass);
                startActivity(ourIntent);
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu)  {
           super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu,menu);

     return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aboutUs:
             Intent i = new Intent("com.srirama.dheeraj.sampleapp.ABOUT");
                startActivity(i);
                break;

            case  R.id.preferences:

                break;
        }
        return false;
    }
}

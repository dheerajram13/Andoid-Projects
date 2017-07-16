package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DHEERAJ on 20-06-2017.
 */
public class SampleBrowser extends Activity implements View.OnClickListener {
    WebView wv;
    EditText url;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samplebrowser);

        wv = (WebView) findViewById(R.id.webView); //webview statement
        wv.setWebViewClient(new ourViewClient());    //the lines of code added
        wv.setWebChromeClient(new WebChromeClient()); //same as above
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);

        try {
            wv.loadUrl("http://www.google.com");
        }catch(Exception e){
         e.printStackTrace();
        }
        Button go = (Button)findViewById(R.id.go);
        Button back = (Button)findViewById(R.id.back);
        Button forward = (Button)findViewById(R.id.forward);
        Button  refresh = (Button)findViewById(R.id.refresh);
        Button clear = (Button)findViewById(R.id.clear);
        url = (EditText)findViewById(R.id.editText);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clear.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go:                   // if go pressed
             String web = url.getText().toString();   // convert the entered url to string
                wv.loadUrl("http://"+web);      //url to load

                // hiding the keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
           break;
            case R.id.back:           //if back pressed
           if(wv.canGoBack())         //check if it go back or not
              wv.goBack();            //and go back to previous page
            break;
            case R.id.forward:      // if forward pressed
                if(wv.canGoForward())      //check if it go forward or not
                    wv.goForward();        // and forward to next page
            break;
            case R.id.refresh:          //if refresh pressed
            wv.reload();                   //reloads the page
            break;
            case R.id.clear:                 // if clear pressed
           wv.clearHistory();           // clears history
            break;

    }
    }
}
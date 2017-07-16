package com.srirama.dheeraj.sampleapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by DHEERAJ on 21-06-2017.
 */
public class ourViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView v,String url) {
        v.loadUrl(url);
        return true;
    }
}

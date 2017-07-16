package com.srirama.dheeraj.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by DHEERAJ on 16-07-2017.
 */

class ourViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url) {
        v.loadUrl(url);
        return true;
    }




}

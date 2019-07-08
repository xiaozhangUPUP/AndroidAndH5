package com.android.zq.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidAndJs extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_and_js);
        findViews();
        initWebView();

    }


    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-07-08 10:01:49 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-07-08 10:01:49 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            // Handle clicks for btnLogin
            login();
        }
    }

    private void login() {
        String name = etNumber.getText().toString().trim();
        String pwd = etPassword.getText().toString().trim();
        login(name);

    }

    private void login(String name) {
        webView.loadUrl("javascript:javaCallJs(" + "'" + name + "'" + ")");
        setContentView(webView);
    }

    private void initWebView() {
        webView = new WebView(this);

        WebSettings settings = webView.getSettings();

        // 设置支持js
        settings.setJavaScriptEnabled(true);

        // 不调用系统浏览器 自定义浏览器
        webView.setWebViewClient(new WebViewClient());

        // 添加javascriptInterface
        // 以后js通过 Android 字段调用 AndroidAndJsInterface 中的任何方法   Android是h5页面中定义的 onclick="window.Android.showToast()"
        webView.addJavascriptInterface(new AndroidAndJsInterface(), "Android");

        // 加载本地html页面
        webView.loadUrl("file:///android_asset/JavaAndJavaScriptCall.html");

        //        setContentView(webView);
    }

    class AndroidAndJsInterface {
        @JavascriptInterface
        public void showToast() {
            makeToast("android 被调用了!!!!!!!");
        }
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}

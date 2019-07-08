package com.android.zq.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private Button btnJavaAndJs;
    private Button btnJsCallJava;
    private Button btnJsCallPhone;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-07-08 09:50:27 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        btnJavaAndJs = (Button) findViewById(R.id.btn_java_and_js);
        btnJsCallJava = (Button) findViewById(R.id.btn_js_call_java);
        btnJsCallPhone = (Button) findViewById(R.id.btn_js_call_phone);

        btnJavaAndJs.setOnClickListener(this);
        btnJsCallJava.setOnClickListener(this);
        btnJsCallPhone.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-07-08 09:50:27 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btnJavaAndJs) {
            // Handle clicks for btnJavaAndJs
            Log.e(TAG, "onClick: btnJavaAndJs");
            makeToast("互动");
            startActivity(new Intent(MainActivity.this, AndroidAndJs.class));
        } else if (v == btnJsCallJava) {
            // Handle clicks for btnJsCallJava
            Log.e(TAG, "onClick: btnJsCallJava");
            makeToast("播放视频");
            startActivity(new Intent(MainActivity.this, JsCallJavaVideoActivity.class));
        } else if (v == btnJsCallPhone) {
            // Handle clicks for btnJsCallPhone
            Log.e(TAG, "onClick: btnJsCallPhone");
            makeToast("打电话");
        }
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}


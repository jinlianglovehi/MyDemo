package com.mqc.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by jinliang on 16/3/4.
 */
public class LogBActivity extends Activity{
    private static final String TAG = LogBActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate ");
        setContentView(R.layout.activity_log_b);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause ");
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ");
    }
}

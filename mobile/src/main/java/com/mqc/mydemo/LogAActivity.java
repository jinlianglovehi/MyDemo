package com.mqc.mydemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.mqc.mydemo.eventbus.MyEvent;
import com.mqc.mydemo.eventbus.ThreadA;
import com.mqc.mydemo.eventbus.ThreadB;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by jinliang on 16/3/4.
 */
public class LogAActivity  extends Activity{
    private static final String TAG = LogAActivity.class.getSimpleName();
//   设置connection 之间的连接的问题
    private ServiceConnection messengerServiceConnection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected ");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected ");

        }
    };

    private ThreadA  threadA  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate ");
        setContentView(R.layout.activity_log_a);

        EventBus.getDefault().register(this);
        Intent intent =new Intent(LogAActivity.this,MyService.class);

        bindService(intent, messengerServiceConnection, BIND_AUTO_CREATE);

        threadA = new ThreadA();
        findViewById(R.id.btn_start_activity).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

////                        startActivity(new Intent(LogAActivity.this,LogBActivity.class));
//                        Intent demo = new Intent(LogAActivity.this, MyService.class);
//                        bindService(demo, messengerServiceConnection, BIND_AUTO_CREATE);

                        Log.i(TAG, "onClick ");
                        threadA.post();

//                        EventBus.getDefault().post(null);
                    }
                }
        );


        threadA.start();

        new ThreadB().start();

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgroundThread(MyEvent event) {
        Log.i(TAG, "backThread 主线程中调用的方法"+ event.getName());
        
       
    }
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
        EventBus.getDefault().unregister(this);
    }
}

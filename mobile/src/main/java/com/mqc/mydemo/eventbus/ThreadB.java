package com.mqc.mydemo.eventbus;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by jinliang on 16/3/4.
 */
public class ThreadB extends Thread {

    private static final String TAG = ThreadB.class.getSimpleName();

    public ThreadB() {

        EventBus.getDefault().register(this);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
//            Log.i(TAG, "run 线程B 正在执行中");


        }
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgroundThread(MyEvent event) {
        Log.i(TAG, "onEventBackgroundThread 线程B 被执行"+ event.getName());

    }

    @Override
    public void destroy() {
        super.destroy();
        EventBus.getDefault().unregister(this);
    }
}

package com.mqc.mydemo.eventbus;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by jinliang on 16/3/4.
 */
public class ThreadA extends Thread {
    private static final String TAG = ThreadA.class.getSimpleName();

    public ThreadA() {
    }

    @Override
    public void run() {
        super.run();
        while (true) {
//            Log.i(TAG, "run 线程A正在执行过程中 ");

        }
    }

    public void post() {
        Log.i(TAG, "backThread posit 事件");
       EventBus.getDefault().post(new MyEvent("测试数据"));
    }

    @Override
    public void destroy() {
        super.destroy();
        EventBus.getDefault().unregister(this);
    }
}

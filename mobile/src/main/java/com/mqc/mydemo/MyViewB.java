package com.mqc.mydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by jinliang on 16/3/1.
 *
 *  view 1 的事件的处理， 事件的分发 ，事件的
 */
public class MyViewB extends LinearLayout{
    private static final String TAG = MyViewB.class.getSimpleName();
    public MyViewB(Context context) {
        super(context);
    }

    public MyViewB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onInterceptTouchEvent B ");
//        return super.onInterceptTouchEvent(ev);
        return true;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i(TAG, "dispatchTouchEvent B");
        return super.dispatchTouchEvent(ev);
//        return true;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent B");

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

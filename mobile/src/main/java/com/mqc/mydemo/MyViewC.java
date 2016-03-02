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
public class MyViewC extends LinearLayout{
    private static final String TAG = MyViewC.class.getSimpleName();
    public MyViewC(Context context) {
        super(context);
    }

    public MyViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onInterceptTouchEvent C ");
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i(TAG, "dispatchTouchEvent C ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent C");

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

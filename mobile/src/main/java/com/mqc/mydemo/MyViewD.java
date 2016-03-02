package com.mqc.mydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jinliang on 16/3/1.
 * <p>
 * view 1 的事件的处理， 事件的分发 ，事件的
 */
public class MyViewD extends View {
    private static final String TAG = MyViewD.class.getSimpleName();

    public MyViewD(Context context) {
        super(context);
    }

    public MyViewD(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewD(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//  单个view 没有拦截时间的处理。


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i(TAG, "dispatchTouchEvent D");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent D");

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

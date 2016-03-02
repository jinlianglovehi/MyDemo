package com.mqc.mydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by jinliang on 16/3/1.
 */
public class MyReleLayout extends LinearLayout {
    public MyReleLayout(Context context) {
        super(context);
    }

    public MyReleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyReleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * onMeasure 设置测量的方法。
     * 负责测量viewGroup 和view 之间的大小的设置。
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        设置宽度的设置
        int width = MeasureSpec.getSize(widthMeasureSpec);
//        设置高度的设置
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
        int childCount = getChildCount();

        for (int i=0 ;i<childCount;i++){

            View child = getChildAt(i);
//            child.measure();
        }

    }


//    设置子view 之间的布局的内容

    /**
     * 设置子view 之间的布局的内容
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    /**
     * onDraw 设置真正的画上去的内容；
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

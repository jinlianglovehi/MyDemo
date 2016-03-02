package com.mqc.mydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by mengqc on 2016/2/25.
 */
public class MyView extends View {
    private static final String TAG = MyView.class.getSimpleName();
    private int height = 260;
    private int percent = 0;
    private Paint mPaint;

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context) {
        this(context, null);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(0.5f);
        mPaint.setColor(getResources().getColor(R.color.color_rect));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw ");
        //left 矩形左边的X轴坐标
        //top 矩形顶部的Y轴坐标
        //right 矩形右边的X轴坐标
        //bottom 矩形底部的Y轴坐标
        this.height = 260 - 2 * percent;
        canvas.drawRect(100, 60, 120, 260, mPaint);
        mPaint.setStrokeWidth(1.0f);
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(100, 70, 95, 70, mPaint);
        canvas.drawLine(90, 70, 85, 70, mPaint);
        canvas.drawLine(80, 70, 75, 70, mPaint);
        mPaint.setStrokeWidth(0f);
        canvas.drawText("肥胖", 50, 75, mPaint);


        canvas.drawLine(100, 130, 95, 130, mPaint);
        canvas.drawLine(90, 130, 85, 130, mPaint);
        canvas.drawLine(80, 130, 75, 130, mPaint);
        canvas.drawText("偏胖", 50, 135, mPaint);


        canvas.drawLine(100, 190, 95, 190, mPaint);
        canvas.drawLine(90, 190, 85, 190, mPaint);
        canvas.drawLine(80, 190, 75, 190, mPaint);
        canvas.drawText("正常", 50, 195, mPaint);


        canvas.drawLine(100, 250, 95, 250, mPaint);
        canvas.drawLine(90, 250, 85, 250, mPaint);
        canvas.drawLine(80, 250, 75, 250, mPaint);
        canvas.drawText("偏瘦", 50, 255, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.color_fill));


//第二个参数  最上0-260  260 最下
        canvas.drawRect(101, height - 10, 119, 259, mPaint);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.bmi_icon);

//        第三个参数  180

        canvas.drawBitmap(bm, 120, height - bm.getHeight() / 2, mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(20);


        canvas.drawText("" + percent, 120 + bm.getWidth() / 2 - 10, height + 5, mPaint);
        mPaint.setColor(getResources().getColor(R.color.color_text));
        mPaint.setTextSize(30);
        canvas.drawText("BMI", 120 + bm.getWidth() + 5, height + 10, mPaint);

    }

    /**
     * 分析
     * 1 设置 颜色的高度
     * 2 设置 红色的高度
     * 3 设置红色内部的数字；
     */

    public void setHeight(int percent) {
        if (percent > 100 || percent < 0) {
            return;
        }
        this.percent = percent;
        invalidate();
    }

}

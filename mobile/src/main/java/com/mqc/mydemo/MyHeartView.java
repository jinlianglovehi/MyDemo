package com.mqc.mydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import java.io.InputStream;

/**
 * Created by jinliang on 16/3/2.
 */
public class MyHeartView extends LinearLayout {
    private static final String TAG = MyHeartView.class.getSimpleName();
    private Paint paint;

    private Bitmap hearBitmap;

    public MyHeartView(Context context) {
        super(context,null);
    }

    public MyHeartView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MyHeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
//        设置画笔的大小；

        paint = new Paint();
        paint.setColor(R.color.colorAccent);
        //加载红心的内容的具体内容
        InputStream is = getResources().openRawResource(R.drawable.icon_heart);
        BitmapDrawable bmpDraw = new BitmapDrawable(is);
        hearBitmap = bmpDraw.getBitmap();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw myheartView 画图的控件");
        for (int i = 0; i < 20; i++) {
            Log.i(TAG, "onDraw ");
            canvas.drawBitmap(hearBitmap, 500 * i, 500* i, paint);
        }
        invalidate();

    }


    public void drawHearMethod(){
        Log.i(TAG, "drawHearMethod ");
        invalidate();
    }
}

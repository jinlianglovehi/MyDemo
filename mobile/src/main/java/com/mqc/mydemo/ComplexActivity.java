package com.mqc.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by jinliang on 16/3/2.
 */
public class ComplexActivity extends Activity {
    private static final String TAG = ComplexActivity.class.getSimpleName();

    @Bind(R.id.ll_content)
    LinearLayout llContent;
    @Bind(R.id.bottom_content)
    LinearLayout bottomContent;
    @Bind(R.id.my_heart_view)
    MyHeartView myHeartView;
    @Bind(R.id.buttonPanel)
    Button buttonPanel;
    private int contentPosition = -300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_layout);
        ButterKnife.bind(this);
        myHeartView.drawHearMethod();
        initObserver();
    }

    /**
     * 注册观察者的内容的信息
     */
    private void initObserver() {

        //观察者的内容
        rx.Observer<String> observer = new rx.Observer<String>() {

            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted ");

            }

            @Override
            public void onError(Throwable throwable) {
                Log.i(TAG, "onError ");

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext ");

            }
        };


    }

    @OnClick(R.id.buttonPanel)
    public void buttonCLick() {

//      被观察者的内容的信息
        rx.Observable observable = rx.Observable.create(
                new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        Log.i(TAG, "call ");
                        subscriber.onNext("Hello");
                        subscriber.onNext("Hi");
                        subscriber.onNext("world");
                        subscriber.onCompleted();
                    }
                }
        );


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        Log.i(TAG, "onTouchEvent getX:" + event.getX());
        Log.i(TAG, "onTouchEvent getY:" + event.getY());
        float moveY = 0;

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                moveY = event.getY();
                Log.i(TAG, "onTouchEvent DownAction getX:" + event.getX());
                Log.i(TAG, "onTouchEvent DownAction getY:" + event.getY());

                break;
            case MotionEvent.ACTION_MOVE:
//                Log.i(TAG, "onTouchEvent moveAction getX:" + event.getX());
                Log.i(TAG, "onTouchEvent moveAction getY:" + (int) (event.getY() - moveY));
                setAnimalView((int) (event.getY() - moveY));

                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent upAction getX:" + event.getX());
                Log.i(TAG, "onTouchEvent upAction getY:" + event.getY());

                break;


        }


        return super.onTouchEvent(event);
    }

    private void setAnimalView(int height) {
        Log.i(TAG, "setAnimalView 动画执行");
        bottomContent.setVisibility(View.VISIBLE);
        AnimatorSet set = new AnimatorSet();
        int result = (contentPosition + height) / 100;

        set.playTogether(
//                ObjectAnimator.ofFloat(bottomContent, "rotationX", 0, 360),
//                ObjectAnimator.ofFloat(bottomContent, "rotationX", contentPosition, result)
                ObjectAnimator.ofFloat(bottomContent, "y", contentPosition, result)
//                ObjectAnimator.ofFloat(bottomContent, "rotation", 0, -90),
//                ObjectAnimator.ofFloat(bottomContent, "translationX", 0, 90),
//                ObjectAnimator.ofFloat(bottomContent, "translationY", 0, 90),
//                ObjectAnimator.ofFloat(bottomContent, "scaleX", 1, 1.5f),
//                ObjectAnimator.ofFloat(bottomContent, "scaleY", 1, 0.5f),
//                ObjectAnimator.ofFloat(bottomContent, "alpha", 1, 0.25f, 1)
        );
        set.setDuration(1 * 1000).start();
        contentPosition = result;

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();

    }


}

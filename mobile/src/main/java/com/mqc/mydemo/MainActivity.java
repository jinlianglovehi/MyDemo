package com.mqc.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btn_start;

    private MyView myView ;

    private int percent = 0  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_content);
//        btn_start = (Button) findViewById(R.id.btn_start);
//        myView = (MyView) findViewById(R.id.myview);
//        btn_start.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        percent +=10 ;
//                        if(percent>100){
//                            percent = 0;
//                        }
//                        myView.setHeight(percent);
//
//                    }
//                }
//        );



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent ");
        return super.onTouchEvent(event);
    }
}

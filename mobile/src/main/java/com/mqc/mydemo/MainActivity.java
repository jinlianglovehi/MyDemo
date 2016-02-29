package com.mqc.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btn_start;

    private MyView myView ;

    private int percent = 0  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
        btn_start = (Button) findViewById(R.id.btn_start);
        myView = (MyView) findViewById(R.id.myview);
        btn_start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        percent +=10 ;
                        if(percent>100){
                            percent = 0;
                        }
                        myView.setHeight(percent);

                    }
                }
        );
    }


}

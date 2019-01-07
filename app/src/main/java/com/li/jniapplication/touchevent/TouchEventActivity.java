package com.li.jniapplication.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import com.li.jniapplication.R;

public class TouchEventActivity extends AppCompatActivity {
    private static final String TAG = "AAAAAAAA------";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG,"-----activity view----dispatchTouchEvent---");
        return super.dispatchTouchEvent(ev);
//        return true;
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"-----activity view----onTouchEvent---");
        return super.onTouchEvent(event);
    }
}

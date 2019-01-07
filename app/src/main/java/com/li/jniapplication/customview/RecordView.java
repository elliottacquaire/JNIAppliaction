package com.li.jniapplication.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class RecordView  extends View {
    private static final String TAG = "AAAAAAAA------";

    public RecordView(Context context) {
        super(context);
    }

    public RecordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG,"-----子 view----dispatchTouchEvent---");
        return super.dispatchTouchEvent(event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"-----子 view----onTouchEvent---");
        return super.onTouchEvent(event);
    }
}

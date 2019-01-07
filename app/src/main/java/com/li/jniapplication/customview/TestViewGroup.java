package com.li.jniapplication.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class TestViewGroup extends ViewGroup {
    private static final String TAG = "AAAAAAAA------";
    public TestViewGroup(Context context) {
        super(context);
    }

    public TestViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int mViewGroupWidth=getMeasuredWidth(); //当前ViewGroup的总宽度

        int mPainterPosX=l;//当前绘制光标X坐标
        int mPainterPosY=t;//当前绘制光标Y坐标

        int childCount=getChildCount();//子控件的数量
        //遍历所有子控件，并在其位置上绘制子控件
        for (int i=0;i<childCount;i++) {
            View childView = getChildAt(i);
            //子控件的宽和高
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();
            //如果剩余控件不够，则移到下一行开始位置
            if (mPainterPosX + width > mViewGroupWidth) {
                mPainterPosX = l;
                mPainterPosY += height;
            }
            //执行childView的绘制
            childView.layout(mPainterPosX, mPainterPosY, mPainterPosX + width, mPainterPosY + height);
            //下一次绘制的X坐标
            mPainterPosX += width;

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG,"-----group view----dispatchTouchEvent---");
//        return super.dispatchTouchEvent(ev);
//        return true;
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG,"-----group view----onInterceptTouchEvent---");
//        return super.onInterceptTouchEvent(ev);
        return true;
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"-----group view----onTouchEvent---");
//        return super.onTouchEvent(event);
        return true;
    }
}

package com.li.jniapplication.di.di;

import android.util.Log;

import javax.inject.Inject;

public class Son implements Father {
    private final static String TAG = Son.class.getSimpleName();


    private String saySomeThing;

    @Inject
    public Son() {
    }


    public Son(String saySomeThing) {
        this.saySomeThing = saySomeThing;
    }

    @Override
    public void test() {
        Log.i(TAG,"ttttteeeesssssstt----" + TAG_FATHER);
    }

    @Override
    public String getName(int num) {
        String name = "son";
        if (num == 0){
            name = name + "-----" + num;
        }
        return name;
    }
}

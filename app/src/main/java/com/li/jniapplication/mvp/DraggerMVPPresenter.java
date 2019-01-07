package com.li.jniapplication.mvp;

import android.util.Log;

import javax.inject.Inject;

public class DraggerMVPPresenter implements DraggerMVPContract.Presenter {

    private DraggerMVPContract.View view;

    @Inject
    public DraggerMVPPresenter(DraggerMVPContract.View view) {
        this.view = view;
    }

    @Override
    public void getBanner(String url) {
        Log.i("sss","DraggerMVPpresemter---------");
    }

    @Override
    public String getTTT(String aaa) {
        return aaa;
    }
}

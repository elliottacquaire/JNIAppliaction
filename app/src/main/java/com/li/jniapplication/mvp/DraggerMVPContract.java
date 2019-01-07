package com.li.jniapplication.mvp;

public interface DraggerMVPContract {

    interface View {
        void showToast(String arg);
    }

    interface Presenter{
        void getBanner(String url);

        String getTTT(String aaa);
    }
}

package com.li.jniapplication.mvp;

import dagger.Module;
import dagger.Provides;

@Module
public class DraggerMVPModule {

    private final DraggerMVPContract.View view;

    public DraggerMVPModule(DraggerMVPContract.View view) {
        this.view = view;
    }

    private void getttt(){

    }

    @Provides
    DraggerMVPContract.View provideMainView() {
        return view;
    }

}

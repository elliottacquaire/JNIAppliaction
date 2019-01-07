package com.li.jniapplication.di.di.dragger2;


import com.li.jniapplication.di.di.CSon;
import dagger.Module;
import dagger.Provides;

@Module
public class DraggerModule {


    @Provides
    public CSon getCSon(){
        return new CSon();
    }


}

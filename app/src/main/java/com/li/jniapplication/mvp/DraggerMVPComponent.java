package com.li.jniapplication.mvp;

import com.li.jniapplication.di.Dragger2Activity;
import com.li.jniapplication.di.di.dragger2.DraggerModule;
import dagger.Component;

@Component(modules = {DraggerModule.class,DraggerMVPModule.class})
public interface DraggerMVPComponent {

    void inject(DraggerMVPActivity draggerMVPActivity);

    void dragger2ActivityInject(Dragger2Activity dragger2Activity);
}

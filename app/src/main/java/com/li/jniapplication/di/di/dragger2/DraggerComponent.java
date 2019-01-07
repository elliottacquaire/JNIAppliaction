package com.li.jniapplication.di.di.dragger2;

import com.li.jniapplication.di.Dragger2Activity;
import dagger.Component;

@Component(modules = {DraggerModule.class})
public interface DraggerComponent {

    void dragger2ActivityInject(Dragger2Activity dragger2Activity);
}

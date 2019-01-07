package com.li.jniapplication.di;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.li.jniapplication.R;
import com.li.jniapplication.di.di.CSon;
import com.li.jniapplication.di.di.Son;
import com.li.jniapplication.di.di.dragger2.DaggerDraggerComponent;
import com.li.jniapplication.mvp.DraggerMVPActivity;

import javax.inject.Inject;

public class Dragger2Activity extends AppCompatActivity {

    @Inject
    Son son;

    @Inject
    CSon cSon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger2);


        DaggerDraggerComponent.builder().build().dragger2ActivityInject(this);

//        DaggerDraggerComponent.builder().build().dragger2ActivityInject(this);



        son.test();
        cSon.say();

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dragger2Activity.this,DraggerMVPActivity.class));
            }
        });

    }
}

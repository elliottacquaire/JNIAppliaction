package com.li.jniapplication.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.li.jniapplication.R;

import javax.inject.Inject;

public class DraggerMVPActivity extends AppCompatActivity implements DraggerMVPContract.View{

    @Inject
    DraggerMVPPresenter presenter;

    private TextView ttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger_mvp);

//        DaggerDraggerComponent.builder().

        DaggerDraggerMVPComponent.builder().draggerMVPModule(new DraggerMVPModule(this)).build().inject(this);

        ttt = (TextView)findViewById(R.id.ttt);
        ttt.setText(presenter.getTTT("aadfsdf"));
    }

    @Override
    public void showToast(String arg) {

    }
}

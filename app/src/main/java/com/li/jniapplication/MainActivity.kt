package com.li.jniapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.li.jniapplication.boxingkongjian.BoXingActivity
import com.li.jniapplication.di.Dragger2Activity
import com.li.jniapplication.mutuitlethread.ThreadActivity
import com.li.jniapplication.touchevent.TouchEventActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.sample_text -> startActivity(Intent().setClass(this,Dragger2Activity().javaClass))
            R.id.sample_btn -> startActivity(Intent().setClass(this,ThreadActivity().javaClass))
            R.id.boxing_btn -> startActivity(Intent().setClass(this, BoXingActivity().javaClass))
            R.id.touchevent_btn -> startActivity(Intent().setClass(this, TouchEventActivity().javaClass))
        }
    }

    fun startActivity(){
        var intent = Intent()
//        intent.setClass()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        sample_text.setOnClickListener (this)
        sample_btn.setOnClickListener(this)
        boxing_btn.setOnClickListener(this)
        touchevent_btn.setOnClickListener(this)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}

package com.li.jniapplication.boxingkongjian;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import com.carlos.voiceline.mylibrary.VoiceLineView;
import com.li.jniapplication.R;
import jaygoo.widget.wlv.WaveLineView;

public class BoXingActivity extends AppCompatActivity {

    private WaveLineView waveLineView;

    private int num;
    private MediaRecorder mMediaRecorder;
    private boolean isAlive = true;
    private VoiceLineView voiceLineView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg == null)return;
            switch (msg.what){
                case 0:
                    waveLineView.setVolume(msg.arg1);
                    voiceLineView.setVolume(msg.arg1);
                    break;
            }

            if(mMediaRecorder==null) return;
            double ratio = (double) mMediaRecorder.getMaxAmplitude() / 100;
            double db = 0;// 分贝
            //默认的最大音量是100,可以修改，但其实默认的，在测试过程中就有不错的表现
            //你可以传自定义的数字进去，但需要在一定的范围内，比如0-200，就需要在xml文件中配置maxVolume
            //同时，也可以配置灵敏度sensibility
            if (ratio > 1)
                db = 20 * Math.log10(ratio);
            //只要有一个线程，不断调用这个方法，就可以使波形变化
            //主要，这个方法必须在ui线程中调用
            voiceLineView.setVolume((int) (db));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_xing);
        waveLineView = (WaveLineView)findViewById(R.id.waveLineView);

        voiceLineView = (VoiceLineView)findViewById(R.id.voicLine);

        RandomThread randomThread = new RandomThread();
//        randomThread.start();

        handler.postDelayed(randomThread,2000);

        waveLineView.startAnim();
//        waveLineView.setVolume(90);

    }

    @Override
    protected void onResume() {
        super.onResume();
        waveLineView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        waveLineView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        waveLineView.release();
    }


    private class RandomThread extends Thread {
        @Override
        public void run() {
            super.run();
            handler.postDelayed(this,500);
            num =  (int)(Math.random()*100);
            Message message = handler.obtainMessage();
            message.arg1 = num;
            message.what = 0;
            handler.sendMessage(message);
        }
    }
}

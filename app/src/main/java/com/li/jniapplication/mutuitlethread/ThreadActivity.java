package com.li.jniapplication.mutuitlethread;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.li.jniapplication.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ThreadActivity extends AppCompatActivity {
    private final String TAGM = ThreadActivity.class.getName()+"==";
    private Thread firstThread;
    private Thread secondThread;
    private Thread thirdThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        firstThread = new FirstThread("firstThread");
        firstThread.start();
        firstThread.setPriority(8);

        secondThread = new Thread(new SecondThread());
        secondThread.start();

//        secondThread.join();

        thirdThread = new ThirdThread("thirdThread");
        thirdThread.start();

        initCachePool();


    }

    private void initCachePool() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(firstThread);
        service.execute(secondThread);
        service.execute(thirdThread);


        service.shutdown();
    }


    class SecondThread implements Runnable {
        private final String TAG = SecondThread.class.getName();

        SecondThread() {
        }

        @Override
        public void run() {
            Log.i(TAGM,Thread.currentThread().getPriority()+"");
            try {
                sleep(2000);
//                Thread.currentThread().join();
                firstThread.join();
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAGM,Thread.currentThread().getName());
        }
    }


    class FirstThread extends Thread {
        private final String TAG = FirstThread.class.getName();

        FirstThread(@NonNull String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            Log.i(TAGM,Thread.currentThread().getPriority()+"");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAGM,Thread.currentThread().getName());
        }
    }

    class ThirdThread extends Thread {
        private final String TAG = ThirdThread.class.getName();

        ThirdThread() {
        }

        ThirdThread(@NonNull String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            Log.i(TAGM,Thread.currentThread().getPriority()+"");
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAGM,Thread.currentThread().getName());
        }
    }
}

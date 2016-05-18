package com.example.elchen.user;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.firebase.client.Firebase;

public class MyService extends Service {
    public MyService() {
    }

    final class MyThread implements Runnable {
        int startID;
        public MyThread(int startID) {
            this.startID = startID;
        }

        public void run() {
            String [] arr = {"hello","from", "user", "1"};
            Firebase db = new Firebase("https://elchen-110.firebaseio.com/second");

            for (String s : arr) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Thread is sleeping");
                    db.setValue(s);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }


        }
    }

    public void onHandleIntent (Intent intent) {
        if (intent != null) {
            synchronized (this) {
                try {
                    wait(150000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopService(intent);
            }
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

package com.example.elchen.user;

import com.firebase.client.Firebase;
/**
 * Created by elchen on 5/18/2016.
 */
public class FirebaseContext extends android.app.Application {
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}

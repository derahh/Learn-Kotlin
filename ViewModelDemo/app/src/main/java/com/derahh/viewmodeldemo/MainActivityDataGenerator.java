package com.derahh.viewmodeldemo;

import android.util.Log;

import java.util.Random;

public class MainActivityDataGenerator {

    private String TAG = this.getClass().getSimpleName();
    private String myRandomNumber;

    public String getNumber() {
        Log.i(TAG, "Get number");
        if (myRandomNumber == null) {
            cretaeNumber();
        }
        return myRandomNumber;
    }

    private void cretaeNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        myRandomNumber = "Number: " +(random.nextInt(10 - 1) + 1);
    }
}

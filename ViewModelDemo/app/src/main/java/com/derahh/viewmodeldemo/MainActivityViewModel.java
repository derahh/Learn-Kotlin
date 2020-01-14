package com.derahh.viewmodeldemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get number");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            cretaeNumber();
        }
        return myRandomNumber;
    }

    public void cretaeNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        myRandomNumber.setValue("Number: " +(random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}

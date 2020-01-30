package com.derahh.qiscuschattest;

import android.app.Application;

import com.qiscus.sdk.chat.core.QiscusCore;

public class CeriwisApps extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        QiscusCore.init(this, "kungflu");
    }
}

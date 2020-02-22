package com.derahh.qiscuschattest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qiscus.sdk.chat.core.QiscusCore;
import com.qiscus.sdk.chat.core.data.model.QiscusAccount;
import com.qiscus.sdk.chat.core.data.remote.QiscusApi;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUser();
    }

    private void setUser() {
        QiscusCore.setUser("derah666@gmail.com", "tunggudulu")
                .withUsername("Dedi Rahmansah")
                //.withAvatarUrl(avatarUrl)
                //.withExtras(extras)
                .save(new QiscusCore.SetUserListener() {
                    @Override
                    public void onSuccess(QiscusAccount qiscusAccount) {
                        //on success
                        openChat();
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        //on error
                    }
                });
    }

    private void openChat() {

    }
}

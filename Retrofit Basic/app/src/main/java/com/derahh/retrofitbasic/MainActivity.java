package com.derahh.retrofitbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.derahh.retrofitbasic.adapter.CustomAdapter;
import com.derahh.retrofitbasic.model.PhotoData;
import com.derahh.retrofitbasic.services.ApiClient;
import com.derahh.retrofitbasic.services.GetService;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetService service = ApiClient.getRetrofitInstance().create(GetService.class);
        Call<List<PhotoData>> call;
    }
}

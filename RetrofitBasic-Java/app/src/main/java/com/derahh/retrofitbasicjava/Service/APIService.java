package com.derahh.retrofitbasicjava.Service;

import com.derahh.retrofitbasicjava.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("users")
    Call<List<User>> fetchAllUser();
}

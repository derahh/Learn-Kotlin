package com.derahh.retrofitbasic.services;

import com.derahh.retrofitbasic.model.PhotoData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {
    @GET("/photos")
    Call<List<PhotoData>> getAllPhoto;
}

package com.example.thepod.httpclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ThePodService {

    @POST("createAccount")
    Call<List<Users>> getUsers();
}

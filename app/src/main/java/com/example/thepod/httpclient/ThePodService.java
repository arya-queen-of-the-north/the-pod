package com.example.thepod.httpclient;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ThePodService {
    @FormUrlEncoded
    @POST("users/createAccount")
    Call<ResponseBody> createUser(
            @Field("email")String email,
            @Field("password")String password,
            @Field("first_name")String firstName,
            @Field("last_name")String lastName,
            @Field("confirm_password")String confirmPassword
    );
}

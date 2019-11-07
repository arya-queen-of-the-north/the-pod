package com.example.thepod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thepod.R;
import com.example.thepod.httpclient.ThePodService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);



    }


    public void navigateBack(View view) {
        Intent intent = new Intent(this,LoginPageActivity.class);
        startActivity(intent);
        finish();
    }





}

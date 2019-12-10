package com.example.thepod.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.thepod.login.LoginPageActivity;
import com.example.thepod.R;

public class RegistrationActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);



    }


    public void navigateBack(View view) {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
        finish();
    }



}

package com.example.thepod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void openRegistration2Activity(View v){
        Intent intent = new Intent(this,Registration2Activity.class);
        startActivity(intent);
    }

    public void navigateBack(View v){
        Intent intent = new Intent(this,LoginPageActivity.class);
        startActivity(intent);
        finish();
    }
}

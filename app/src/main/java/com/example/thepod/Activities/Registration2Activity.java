package com.example.thepod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.thepod.R;

public class Registration2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
    }

    public void navigateBack(View v){

        Intent registrationActivity2 = new Intent(
                this,RegistrationActivity.class);
        startActivity(registrationActivity2);
        finish();
    }


}

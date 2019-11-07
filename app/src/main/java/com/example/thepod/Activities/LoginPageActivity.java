package com.example.thepod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.thepod.R;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


    }

    public void openRegistrationActivity(View v){
        Intent intent = new Intent(this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }


}

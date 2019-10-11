package com.example.thepod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, Registration2Activity.class));
    }

    public void openRegistration(){
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }
}

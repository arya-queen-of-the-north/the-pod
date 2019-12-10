package com.example.thepod.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thepod.R;
import com.example.thepod.foodmenu.MenuActivity;
import com.example.thepod.registration.RegistrationActivity;


public class LoginPageActivity extends AppCompatActivity {


    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login_button = findViewById(R.id.login_button);


    }


    public void userLogin(View v){
        startActivity(new Intent(this, MenuActivity.class));

    }



    public void openRegistrationActivity(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }


}

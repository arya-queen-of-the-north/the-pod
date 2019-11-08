package com.example.thepod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thepod.MenuActivity;
import com.example.thepod.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginPageActivity extends AppCompatActivity {

    @BindView(R.id.login_button)
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.login_button)
    public void userLogin(){
        startActivity(new Intent(this, MenuActivity.class));

    }



    public void openRegistrationActivity(View v){
        Intent intent = new Intent(this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }


}

package com.example.thepod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thepod.MenuActivity;
import com.example.thepod.R;
import com.example.thepod.httpclient.RetrofitClient;
import com.example.thepod.httpclient.ThePodService;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText ediTextPassword;
    private EditText editTextConfirmPassword;

    private static final String TAG = "RegistrationActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        ediTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://the-pod.herokuapp.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ThePodService service = retrofit.create(ThePodService.class);

        findViewById(R.id.registerButton).setOnClickListener(this);
    }




    public void navigateBack(View v){
        Intent intent = new Intent(this,LoginPageActivity.class);
        startActivity(intent);
        finish();
    }

    public void userSignUp(){
        String email = editTextEmail.getText().toString().trim();
        String password = ediTextPassword.getText().toString().trim();
        String firstName= editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();


        if (email.isEmpty()){
            editTextEmail.setError("Email is empty");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            ediTextPassword.setError("Email is empty");
            ediTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            ediTextPassword.setError("Password should be atleast 6 characters long");
            ediTextPassword.requestFocus();
            return;
        }
        if (firstName.isEmpty()){
            editTextFirstName.setError("First Name is empty");
            editTextFirstName.requestFocus();
            return;
        }

        if (lastName.isEmpty()){
            editTextLastName.setError("Last Name is empty");
            editTextLastName.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getThePodService()
                .createUser(email,password,firstName,lastName,confirmPassword);
        startActivity(new Intent(getApplication(), MenuActivity.class));
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.d(TAG, "onResponse-------- : "+response.code());
//                  //  String responseString = response.body().string();
//                   // Toast.makeText(RegistrationActivity.this,responseString,Toast.LENGTH_LONG).show();
//                    Log.d(TAG, "onResponse: ");
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                startActivity(new Intent(getApplication(), MenuActivity.class));

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerButton:
                userSignUp();
                break;
            case R.id.textViewLogin:

                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

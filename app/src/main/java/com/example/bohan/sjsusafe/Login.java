package com.example.bohan.sjsusafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText etUsername, etPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.Password);
    }

    public void userRegister(View view) {
        // Handle navigation view item clicks here.

        Intent RegisterNav = new Intent(this, ProfileActivity.class);
        startActivity(RegisterNav);

    }

    public void userLogin(View view) {

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        String method="login";
        //Log.d("STATE",method.toString());
        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute(method,username,password,null,null,null,null,null);
        finish();

    }
}
package com.example.bohan.sjsusafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void userRegister(View view) {
        // Handle navigation view item clicks here.

        Intent RegisterNav = new Intent(this, ProfileActivity.class);
        startActivity(RegisterNav);

    }

    public void userLogin(View view){}

}

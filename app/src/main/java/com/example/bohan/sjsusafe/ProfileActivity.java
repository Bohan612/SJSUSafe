package com.example.bohan.sjsusafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    EditText etUsername, etPassword,etSID, etEmail, etPhone, etEPhone, etBGroup;
    String username,password,sid,email,phone,ephone,bgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        etUsername=(EditText)findViewById(R.id.username);
        etPassword=(EditText)findViewById(R.id.password);
        etSID=(EditText)findViewById(R.id.StudentId);
        etEmail=(EditText)findViewById(R.id.SJSUEmail);
        etEPhone=(EditText)findViewById(R.id.EPhone);
        etPhone=(EditText)findViewById(R.id.Phone);
        etBGroup=(EditText)findViewById(R.id.BloodGroup);

    }



    public void userRegister(View view){
        username=etUsername.getText().toString();
        password=etPassword.getText().toString();
        sid=etSID.getText().toString();
        email=etEmail.getText().toString();
        phone=etPhone.getText().toString();
        ephone=etEPhone.getText().toString();
        bgroup=etBGroup.getText().toString();

        String method="register";

        BackgroundTask backgroundTask= new BackgroundTask(this);

        backgroundTask.execute(method,username,password,sid,email,phone,ephone,bgroup);

        finish();


    }
}

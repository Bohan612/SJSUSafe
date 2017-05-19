package com.example.bohan.sjsusafe;

import android.app.Activity;
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

        etUsername=(EditText)findViewById(R.id.UserName);
        etPassword=(EditText)findViewById(R.id.password);
        etSID=(EditText)findViewById(R.id.StudentId);
        etEmail=(EditText)findViewById(R.id.SJSUEmail);
        etEPhone=(EditText)findViewById(R.id.EPhone);
        etPhone=(EditText)findViewById(R.id.Phone);
        etBGroup=(EditText)findViewById(R.id.BloodGroup);

    }

    public void register(View view){
        if(etUsername!=null) {
           username = etUsername.getText().toString();

       }

        if(etPassword!=null) {
            password = etPassword.getText().toString();
        }
        if(etSID!=null) {
            sid = etSID.getText().toString();
        }
        if(etEmail!=null) {
            email = etEmail.getText().toString();
        }
        if(etPhone!=null) {
            phone = etPhone.getText().toString();
        }if(etEPhone!=null) {
            ephone = etEPhone.getText().toString();
        }
        if(etBGroup!=null) {
            bgroup = etBGroup.getText().toString();
        }
        String method="register";
        //Log.d("STATE",method.toString());
        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute(method,username,password,sid,email,phone,ephone,bgroup);
        finish();
    }
}

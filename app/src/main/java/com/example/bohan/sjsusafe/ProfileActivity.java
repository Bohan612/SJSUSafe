package com.example.bohan.sjsusafe;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


        etEmail.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validation.isEmailAddress(etEmail, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        etPhone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.isPhoneNumber(etPhone, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        etEPhone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.isPhoneNumber(etEPhone, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        if(etBGroup!=null) {
            bgroup = etBGroup.getText().toString();
        }



        String method="register";
        //Log.d("STATE",method.toString());

        if ( checkValidation () ) {
            if(etEmail!=null) {
                email = etEmail.getText().toString();
            }
            if(etPhone!=null) {
                phone = etPhone.getText().toString();
            }
            if(etEPhone!=null) {
                ephone = etEPhone.getText().toString();
            }

            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, username, password, sid, email, phone, ephone, bgroup);
            finish();
        } else{
            Toast.makeText(this, "Form contains error", Toast.LENGTH_LONG).show();
         }

    }


    private boolean checkValidation() {
        boolean ret = true;

        //if (!Validation.hasText(etNormalText)) ret = false;
        if (!Validation.isEmailAddress(etEmail, true)) ret = false;
        if (!Validation.isPhoneNumber(etPhone, true)) ret = false;
        if (!Validation.isPhoneNumber(etEPhone, true)) ret = false;
        return ret;
    }





}

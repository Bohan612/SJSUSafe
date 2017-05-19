package com.example.bohan.sjsusafe;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Student on 5/18/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;

    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String regurl="http://10.0.2.2/register.php";
        String loginurl="http://10.0.2.2/login.php";
        String method=params[0];
        if(method.equals("register")){

            String username=params[1];
            String password=params[2];
            String sid=params[3];
            String email=params[4];
            String phone=params[5];
            String ephone=params[6];
            String bgroup=params[7];
            try {
                URL url= new URL(regurl);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("UserName","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8")+"&"+
                             URLEncoder.encode("Password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8")+"&"+
                             URLEncoder.encode("SID","UTF-8") + "=" + URLEncoder.encode(sid,"UTF-8")+"&"+
                             URLEncoder.encode("SEmail","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8")+"&"+
                             URLEncoder.encode("Phone","UTF-8") + "=" + URLEncoder.encode(phone,"UTF-8")+"&"+
                             URLEncoder.encode("EPhone","UTF-8") + "=" + URLEncoder.encode(ephone,"UTF-8")+"&"+
                             URLEncoder.encode("BloodGroup","UTF-8") + "=" + URLEncoder.encode(bgroup,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "Registration successful";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("login")){
            String username=params[1];
            String password=params[2];
            try {
                URL url= new URL(loginurl);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("UserName","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is=httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    response+=line;

                }
                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration successful")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
    }
}

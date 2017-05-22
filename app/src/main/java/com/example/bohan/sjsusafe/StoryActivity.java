package com.example.bohan.sjsusafe;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StoryActivity extends AppCompatActivity{
    int[] IMAGES={R.drawable.assault,R.drawable.sexualassault,R.drawable.robbery};
    String[] NAMES={"Assault","Sexual Assault","Robbery"};
    String[] DESCRIPTIONS={"Assault","Assault","Robbery"};
    String[] RName={"M","B","H"};
    String[] IName={"1","2","3"};
    String JSON_STRING;
    JSONArray jsonarray;
    JSONObject jsonobj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ListView listview =(ListView)findViewById(R.id.listview);
        getJSON();
        CustomAdapter customAdapter=new CustomAdapter();

        try {
            jsonobj=new JSONObject(JSON_STRING);
            jsonarray=jsonobj.getJSONArray("server_response");
            int count=0;
            String IncidentType, Location, Date, Description, ReporterName;

            while(count<jsonarray.length()){
                JSONObject jo=jsonarray.getJSONObject(count);
                IncidentType=jo.getString("IC");
                Location=jo.getString("Location");
                Date=jo.getString("Date");
                Description=jo.getString("description");
                ReporterName=jo.getString("ReporterName");

                Incidentproperties objIncident=new Incidentproperties(IncidentType, Location, Date, Description, ReporterName);
                customAdapter.add(objIncident);
                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
        listview.setAdapter(customAdapter);




    }

    public void getJSON(){
        String method="GetNews";
        BackgroundWork backgroundobj= new BackgroundWork(this);
        try {
            JSON_STRING=backgroundobj.execute(method,null,null,null,null,null,null).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    class CustomAdapter extends BaseAdapter{
        List list=new ArrayList();

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.customlayout,null);
        //    ImageView imageView=(ImageView)convertView.findViewById(R.id.imI);
          TextView tvIncidentDescription=(TextView)convertView.findViewById(R.id.tvDescription);
            TextView tvLocation=(TextView)convertView.findViewById(R.id.tvLocation);
            TextView tvReporterName=(TextView)convertView.findViewById(R.id.tvName);
            TextView tvDate=(TextView)convertView.findViewById(R.id.tvDate);
            Incidentproperties objIncident=(Incidentproperties)this.getItem(position);

           tvIncidentDescription.setText(objIncident.getDescription());
            tvLocation.setText(objIncident.getLocation());
            tvReporterName.setText(objIncident.getReporterName());
            tvDate.setText("Date: " + objIncident.getDate());

            if(position%2==0){
                convertView.setBackgroundColor(Color.rgb(2, 22, 48));

            }
            else{
                convertView.setBackgroundColor(Color.rgb(123, 126, 130));

            }


            return convertView;
        }

        public void add(Incidentproperties objIncident) {
            list.add(objIncident);


        }
    }


    public class BackgroundWork extends AsyncTask<String,Void,String> {
        Context ctx;

        String value;
        BackgroundWork(Context ctx){
            this.ctx=ctx;
        }

        @Override
        protected String doInBackground(String... params) {

            String Newsurl="http://10.0.2.2/GetNews.php";

            String method=params[0];
             if(method.equals("GetNews")){
                try {
                    URL url= new URL(Newsurl);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    InputStream is=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is));
                    StringBuilder stringBuilder=new StringBuilder();
                    while((JSON_STRING=bufferedReader.readLine())!=null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }
                    bufferedReader.close();
                    is.close();
                    httpURLConnection.disconnect();
                    value=stringBuilder.toString().trim();
                    return value;


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
            /*if(result!=null) {
             //   Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
               JSON_STRING=result;
            }
            */

    super.onPostExecute(result);
        }
    }


}

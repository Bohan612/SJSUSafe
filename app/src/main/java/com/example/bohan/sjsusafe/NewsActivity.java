package com.example.bohan.sjsusafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewsActivity extends AppCompatActivity {

        EditText etIncidentType, etLocation, etDate,etIncidentDescription,etIncidentID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

       // RelativeLayout mealLayout = (RelativeLayout) findViewById(R.id.mealLayout);

      //  mealLayout.setBackgroundColor(Color.RED);


        //maitri
    }

    public void OnLogin(View view){
        String type="News";
        String IncidentType=etIncidentType.getText().toString();
        BackgroundWorker Bgobj=new BackgroundWorker(this);
        Bgobj.execute(type,IncidentType,null);

    }



}

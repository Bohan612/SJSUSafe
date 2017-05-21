package com.example.bohan.sjsusafe;

/**
 * Created by Student on 5/21/2017.
 */

public class Incidentproperties {

    private String IncidentType, Location, Date, Description, ReporterName;

    public Incidentproperties(String IncidentType,String Location,String Date,String Description,String ReporterName){

        this.IncidentType=IncidentType;
        this.Location=Location;
        this.Date=Date;
        this.Description=Description;
        this.ReporterName=ReporterName;
    }

    public String getIncidentType(){
        return IncidentType;
    }

    public String getLocation(){
        return Location;
    }
    public String getDate(){
        return Date;
    }
    public String getDescription(){
        return Description;
    }
    public String getReporterName(){
        return ReporterName;
    }

    public void setIncidentType(String IncidentType){
         this.IncidentType=IncidentType;
    }

    public void setReporterName(String ReporterName){
        this.ReporterName=ReporterName;
    }
    public void setDescription(String Description){
        this.Description=Description;
    }

    public void setDate(String Date){
        this.Date=Date;
    }

    public void setLocation(String Location){
        this.Location=Location;
    }



}

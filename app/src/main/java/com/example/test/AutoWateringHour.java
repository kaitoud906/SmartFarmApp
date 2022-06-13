package com.example.test;

public class AutoWateringHour {
    private String hour,minute;
    private int id;

    public AutoWateringHour(int id, String hour,String minute){
        this.hour = hour;
        this.minute = minute;
        this.id = id;
    }
    public String getHour(){
        return this.hour;
    }
    public String getMinute(){
        return this.minute;
    }
    public void setHour(String hour){
        this.hour = hour;
    }
    public void setMinute(String minute){
        this.minute = minute;
    }

}

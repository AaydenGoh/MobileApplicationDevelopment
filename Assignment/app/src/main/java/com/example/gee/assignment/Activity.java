package com.example.gee.assignment;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Gee on 12/12/2016.
 */

public class Activity {
    private String name;
    private String starttime;
    private String endtime;


    public Activity() {
    }

    public Activity(String name, String starttime, String endtime) {
        this.name = name;

        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStartTime() {
        return starttime;
    }

    public void setTime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndTime() {
        return endtime;
    }

    public void setEndTime(String endtime) {
        this.endtime = endtime;
    }
}

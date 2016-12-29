package com.example.gee.assignment;

/**
 * Created by Gee on 12/12/2016.
 */

public class Day {
    private String day;
    private Activity activity;

    public Day() {

    }

    public Day(String day, Activity activity) {
        this.day = day;
        this.activity = activity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}

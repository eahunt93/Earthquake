package com.example.android.quakereport;

/**
 * Created by elija on 8/18/2017.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long TimeinMilliseconds;
    private String url;

    public Earthquake(double magnitude, String location, long TimainMilliseconds, String url){
        this.location = location;
        this.TimeinMilliseconds = TimainMilliseconds;
        this.magnitude = magnitude;
        this.url = url;
    }

    public long getTimeinMilliseconds() {
        return TimeinMilliseconds;
    }

    public void setTimeinMilliseconds(long timeinMilliseconds) {
        TimeinMilliseconds = timeinMilliseconds;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

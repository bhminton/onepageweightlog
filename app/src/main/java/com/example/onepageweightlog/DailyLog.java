package com.example.onepageweightlog;

public class DailyLog {

    public String weight;


    public DailyLog(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DailyLog{" +
                "weight=" + weight +
                '}';
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}

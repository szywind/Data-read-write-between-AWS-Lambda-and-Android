package com.example.shenzhenyuan.myapplication;

import com.google.gson.JsonArray;

import org.json.JSONArray;


/**
 * Created by shenzhenyuan on 12/30/15.
 */
public class myData {
    public String firstName;
    public String lastName;
    public String details;
    public JSONArray aaa;
    public String bbb;

    public myData(myData d){
        firstName = d.firstName;
        lastName  = d.lastName;
        details = d.details;
        aaa = d.aaa;
        bbb = d.bbb;
    }
    public myData(){}
}

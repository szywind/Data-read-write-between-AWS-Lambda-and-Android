package com.example.shenzhenyuan.myapplication;

/**
 * Created by shenzhenyuan on 12/24/15.
 */

/*
public class RequestClass {
    String firstName;
    String lastName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public RequestClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public RequestClass() {
    }
}
*/

public class RequestClass{
    myData data;
    public RequestClass(myData d) {
        data = new myData(d);
    }
    public RequestClass() {
        data = new myData();
    }
}
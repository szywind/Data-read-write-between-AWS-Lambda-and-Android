package com.example.shenzhenyuan.myapplication;

/**
 * Created by shenzhenyuan on 12/24/15.
 */


/*
public class ResponseClass {
    //String greetings;
    String firstName;
    String lastName;
//    public String getGreetings() {
//        return greetings;
//    }
//    public void setGreetings(String greetings) {
//        this.greetings = greetings;
//    }
    public ResponseClass(String a, String b) {
        this.firstName = a;this.lastName = b;
    }
    public ResponseClass() {
    }
}

*/

public class ResponseClass {
    //String greetings;
    public myData mydata;
    //String firstName;
    //String lastName;
    //public String getGreetings() {
    //    return greetings;
    //}
    //public void setGreetings(String greetings) {
    //    this.greetings = greetings;
    //}
    public ResponseClass(myData a) {
        mydata = new myData();
        mydata.firstName = a.firstName;
        mydata.lastName = a.lastName;
    }
    public ResponseClass() {
    }
}

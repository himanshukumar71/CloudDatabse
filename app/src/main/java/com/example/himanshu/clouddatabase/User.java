package com.example.himanshu.clouddatabase;

/**
 * Created by Himanshu on 2/1/2016.
 */
public class User {

    private String name;
    private String birthYear;

    public User(){

    }
    public User(String name, String birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName(){
        return name;
    }
    public String getBirthYear(){
        return birthYear;
    }
}

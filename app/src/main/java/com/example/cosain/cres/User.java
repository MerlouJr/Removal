package com.example.cosain.cres;

/**
 * Created by cosain on 4/22/2017.
 */

public class User {
    public static String name;
    public static String status;


    public User() {

    }

    public User(String name , String status){
        this.name = name;
        this.status = status;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status){
        this.status = status;

    }

    public String getName()
    {
        return name;
    }
    public String getStatus(){

        return status;
    }
}

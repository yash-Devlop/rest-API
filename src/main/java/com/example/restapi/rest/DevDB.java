package com.example.restapi.rest;

public class DevDB implements DB {

    @Override
    public String getData() {
        return "Dev Data";
    } 
}

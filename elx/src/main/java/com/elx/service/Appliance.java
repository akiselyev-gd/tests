package com.elx.service;


public class Appliance {

    public final long deviceId;
    public final String type;

    public Appliance(long id, String type) {
        this.deviceId = id;
        this.type = type;
    }

}
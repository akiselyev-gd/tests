package com.elx.service;

public class Appliance {

    private final long id;
    private final String type;

    public Appliance(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
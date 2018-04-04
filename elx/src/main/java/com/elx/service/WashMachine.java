package com.elx.service;

import org.springframework.data.annotation.Id;

public class WashMachine extends Appliance {

    @Id
    public String storageId;

    private String status;

    public WashMachine() {
        super(-1, "WASH MACHINE");
        status = "UNKNOWN";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
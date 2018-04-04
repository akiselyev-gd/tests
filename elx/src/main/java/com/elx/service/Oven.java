package com.elx.service;

import org.springframework.data.annotation.Id;

public class Oven extends Appliance {

    @Id
    public String storageId;

    private String status;

    public Oven() {
        super(-1, "OVEN");
        status = "UNKNOWN";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
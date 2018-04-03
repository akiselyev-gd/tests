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

    public void setStatus(String new_status) {
        this.status = new_status;
    }

    public String getStatus() {
        return this.status;
    }
}
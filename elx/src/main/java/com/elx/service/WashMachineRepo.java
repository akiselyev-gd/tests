package com.elx.service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WashMachineRepo extends MongoRepository<WashMachine, String> {

    public WashMachine findByDeviceId(long id);

}
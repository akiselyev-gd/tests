package com.elx.service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OvenRepo extends MongoRepository<Oven, String> {

    public Oven findByDeviceId(long id);

}
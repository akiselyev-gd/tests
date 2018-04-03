package com.elx.service;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AppliancesController {

    public static final Logger logger = LoggerFactory.getLogger(AppliancesController.class);

    @Autowired
    private OvenRepo ovenStorage;

    @RequestMapping("/appliances")
    public List<Appliance> getAllDevices() {

        logger.info("Get all available devices");

        List<Appliance> apps = new ArrayList<Appliance>();
        for (Oven one: ovenStorage.findAll()) {
            apps.add(one);
        }

        return apps;
    }

}
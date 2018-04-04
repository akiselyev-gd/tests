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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class AppliancesController {

    public static final Logger logger = LoggerFactory.getLogger(AppliancesController.class);

    @Autowired
    private OvenRepo ovenStorage;

    @Autowired
    private WashMachineRepo washMachineStorage;

    @RequestMapping("/appliances")
    public ResponseEntity<List<Appliance>> getAllDevices() {

        logger.info("Get all available devices");

        List<Appliance> apps = new ArrayList<Appliance>();

        ovenStorage.findAll().forEach(one -> apps.add(one));
        washMachineStorage.findAll().forEach(one -> apps.add(one));

        if (apps.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Appliance>>(apps, HttpStatus.OK);
    }

}
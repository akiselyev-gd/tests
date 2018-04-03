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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/appliances")
public class OvenController {

    public static final Logger logger = LoggerFactory.getLogger(OvenController.class);

    @Autowired
    private OvenRepo ovenStorage;

    @RequestMapping(value = "/ovens", method = RequestMethod.GET)
    public List<Oven> getAllOvens() {

        logger.info("Get all available ovens");

        List<Oven> ovens = new ArrayList<Oven>();
        for (Oven one: ovenStorage.findAll()) {
            ovens.add(one);
        }

        return ovens;
    }

    @RequestMapping(value = "/ovens/{id}", method = RequestMethod.GET)
    public Oven getOvenById(@PathVariable("id") long id) {

        logger.info("Get an oven by id {}", id);

        return new Oven();
    }

    @RequestMapping(value = "/ovens", method = RequestMethod.POST)
    public Oven addNewOven(@RequestBody Oven oven, UriComponentsBuilder ucBuilder) {

        logger.info("Add new oven {}", oven.type);

        ovenStorage.save(oven);

        return oven;
    }

    @RequestMapping(value = "/ovens/{id}", method = RequestMethod.PUT)
    public Oven cahngeOvenState(@PathVariable("id") long id, @RequestBody Oven oven) {

        logger.info("Change status for the oven {}", id);

        Oven one = ovenStorage.findByDeviceId(id);
        if (one != null) {
            one.setStatus(oven.getStatus());
            ovenStorage.save(one);
        }

        return one;
    }


    @RequestMapping(value = "/ovens/{id}", method = RequestMethod.DELETE)
    public Object deleteOvenById(@PathVariable("id") long id) {
        logger.info("Delete the oven {}", id);

        return null;
    }
}

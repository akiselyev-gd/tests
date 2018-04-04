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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/appliances")
public class WashMachineController {

    public static final Logger logger = LoggerFactory.getLogger(OvenController.class);

    @Autowired
    private WashMachineRepo washMachineStorage;

    @RequestMapping(value = "/washmachines", method = RequestMethod.GET)
    public ResponseEntity<List<WashMachine>> getAllWashMachines() {

        logger.info("Get all available wash machines");

        List<WashMachine> machines = new ArrayList<WashMachine>();
        washMachineStorage.findAll().forEach(one -> machines.add(one));

        if (machines.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<WashMachine>>(machines, HttpStatus.OK);
    }

    @RequestMapping(value = "/washmachines/{id}", method = RequestMethod.GET)
    public WashMachine getWashMachineById(@PathVariable("id") long id) {

        logger.info("Get a wash machine by id {}", id);

        return new WashMachine();
    }

    @RequestMapping(value = "/washmachines", method = RequestMethod.POST)
    public WashMachine addNewWashMachine(@RequestBody WashMachine machine, UriComponentsBuilder ucBuilder) {

        logger.info("Add new wash machine {}", machine.type);

        washMachineStorage.save(machine);

        return machine;
    }

    @RequestMapping(value = "/washmachines/{id}", method = RequestMethod.PUT)
    public WashMachine cahngeWashMachineState(@PathVariable("id") long id, @RequestBody WashMachine machine) {

        logger.info("Change status for the wash machine {}", id);

        WashMachine one = washMachineStorage.findByDeviceId(id);
        if (one != null) {
            one.setStatus(machine.getStatus());
            washMachineStorage.save(one);
        }

        return one;
    }


    @RequestMapping(value = "/washmachines/{id}", method = RequestMethod.DELETE)
    public Object deleteWashMachineById(@PathVariable("id") long id) {
        logger.info("Delete the wash machine {}", id);

        return null;
    }
}

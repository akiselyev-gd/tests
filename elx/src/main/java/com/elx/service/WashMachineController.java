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
    public ResponseEntity<WashMachine> getWashMachineById(@PathVariable("id") long id) {

        logger.info("Get a wash machine by id {}", id);

        WashMachine machine = washMachineStorage.findByDeviceId(id);
        if (machine == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<WashMachine>(machine, HttpStatus.OK);
    }

    @RequestMapping(value = "/washmachines", method = RequestMethod.POST)
    public ResponseEntity<?> addNewWashMachine(@RequestBody WashMachine machine, UriComponentsBuilder ucBuilder) {

        logger.info("Add new wash machine {}", machine);

        if (washMachineStorage.findByDeviceId(machine.deviceId) != null) {
            logger.info("Device with given ID already exits");
            return new ResponseEntity("ALREADY EXISTS", HttpStatus.CONFLICT);
        }

        WashMachine newMachine = washMachineStorage.save(machine);
        if (newMachine == null)
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<WashMachine>(newMachine, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/washmachines/{id}", method = RequestMethod.PUT)
    public ResponseEntity<WashMachine> cahngeWashMachineState(@PathVariable("id") long id, @RequestBody WashMachine machine) {

        logger.info("Change status for the wash machine {}", id);

        WashMachine one = washMachineStorage.findByDeviceId(id);
        if (one != null) {
            one.setStatus(machine.getStatus());
            WashMachine changedMachine = washMachineStorage.save(one);
            if (changedMachine == null)
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity(changedMachine, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/washmachines/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWashMachineById(@PathVariable("id") long id) {
        logger.info("Delete the wash machine {}", id);

        WashMachine one = washMachineStorage.findByDeviceId(id);
        if (one !=  null) {
            washMachineStorage.delete(one);
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

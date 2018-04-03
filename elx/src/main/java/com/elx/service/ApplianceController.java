package com.elx.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplianceController {

    @RequestMapping("/appliances")
    public List<Appliance> appliances() {

        List<Appliance> appList = new ArrayList<Appliance>();
        appList.add(new Appliance(1, "wash machine"));
        appList.add(new Appliance(2, "wash machine"));
        appList.add(new Appliance(3, "wash machine"));

        return appList;
    }
}
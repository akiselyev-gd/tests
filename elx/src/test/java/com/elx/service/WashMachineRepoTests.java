package com.elx.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WashMachineRepoTests {

    @Autowired
    WashMachineRepo repo;

    @Before
    public void setUp() {

        repo.deleteAll();

        repo.save(new WashMachine());
    }


    @Test
    public void findsByDeviceId() {

        WashMachine result = repo.findByDeviceId(-1);

        assertThat(result).extracting("type").contains("WASH MACHINE");
    }

}
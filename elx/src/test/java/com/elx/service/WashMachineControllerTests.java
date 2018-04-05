package com.elx.service;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.AnyOf.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WashMachineControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void ApplianceGetAllWashMachinesStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(get("/appliances/washmachines")).andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

    @Test
    public void ApplianceGetWashMachineByIdStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(get("/appliances/washmachines/1")).andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

}
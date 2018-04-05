package com.elx.service;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.AnyOf.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WashMachineControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void GetAllWashMachinesStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(get("/appliances/washmachines")).andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

    @Test
    public void GetWashMachineByIdStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(get("/appliances/washmachines/1")).andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

    @Test
    public void CreateNewWashMachineStatusCreatedOrConflict() throws Exception {
        int status = this.mvc.perform(post("/appliances/washmachines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new WashMachine())))
                .andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_CREATED), equalTo(HttpServletResponse.SC_CONFLICT)));
    }

    @Test
    public void ChangeWashMachineStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(put("/appliances/washmachines/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new WashMachine())))
                .andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

    @Test
    public void DeleteWashMachineStatusOkOrNotFound() throws Exception {
        int status = this.mvc.perform(delete("/appliances/washmachines/1")).andDo(print()).andReturn().getResponse().getStatus();
        assertThat(status, anyOf(equalTo(HttpServletResponse.SC_OK), equalTo(HttpServletResponse.SC_NOT_FOUND)));
    }

}
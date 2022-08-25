package com.example.devadmin_technical_task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DevadminTechnicalTaskApplication.class)
@AutoConfigureMockMvc
@Transactional
public class DatabaseControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void select_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/select")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableName\" : \"city\"," +
                                "\"columns\" : [\"id\", \"name\", \"district\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void create_Returns_201() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableName\" : \"country\"," +
                                "\"columns\" : [\"id VARCHAR PRIMARY KEY\", \"name VARCHAR NOT NULL\", \"currency VARCHAR NOT NULL\"]}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void delete_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableName\" : \"city\", \"condition\" : \"id = 1\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void insert_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableName\" : \"city\"," +
                                "\"columns\" : [\"id\", \"name\", \"country_code\", \"district\", \"population\"]," +
                                "\"values\" : [\"3\", \"Amsterdam\", \"+31\", \"Oost\", \"135767\"]}"))
                .andExpect(status().isOk());
    }
}

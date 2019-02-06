package com.disney.studios;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PetRepositoryIntegrationTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getPictures() throws Exception {
        this.mvc.perform(get("/dogs/pictures")).andExpect(status().isOk());
    }

    @Test
    public void getPictureById() throws Exception {
        this.mvc.perform(get("/dogs/87")).andExpect(status().isOk())
                .andExpect(content().json("{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":0}"));
    }

    @Test
    public void getPictureByWrongId() throws Exception {
        this.mvc.perform(get("/dogs/11187")).andExpect(status().is4xxClientError());
    }

    @Test
    public void putVoteUp() throws Exception {
        this.mvc.perform(put("/dogs/87/up")).andExpect(status().is4xxClientError());
    }


    @Test
    public void putVoteDown() throws Exception {
        this.mvc.perform(put("/dogs/87/down").header(HttpHeaders.AUTHORIZATION,
                "Basic " + Base64Utils.encodeToString("user:password".getBytes())))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":87,\"picture\":\"http://i.imgur.com/ToYsMEC.png\",\"breed\":\"retriever\",\"votes\":0}"));
    }

    @Test
    public void putVoteDownAuthenticated() throws Exception {
        this.mvc.perform(put("/dogs/87/down")).andExpect(status().is4xxClientError());
    }


}
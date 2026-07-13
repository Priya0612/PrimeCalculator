package com.PrimeService.PrimeService.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PrimeServiceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnJsonPayloadByDefault() throws Exception {
        mockMvc.perform(get("/primes/10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.prime[0]").value(2))
                .andExpect(jsonPath("$.prime[3]").value(7));
    }

    @Test
    void shouldReturnXmlPayloadWhenRequested() throws Exception {
        mockMvc.perform(get("/primes/10")
                        .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
                .andExpect(xpath("/PrimeResponse/prime/prime[1]").string("2"))
                .andExpect(xpath("/PrimeResponse/prime/prime[4]").string("7"));
    }

    @Test
    void shouldReturnBadRequestForNegativeNumbers() throws Exception {
        mockMvc.perform(get("/primes/-5"))
                .andExpect(status().isBadRequest());
    }
}

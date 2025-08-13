package com.example.british_time_converter.controller;
import com.example.british_time_converter.service.BritishTimeConvertorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(BritishTimeConvertor.class)
@Import(BritishTimeConvertorTest.TestConfig.class)
class BritishTimeConvertorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BritishTimeConvertorService britishTimeConvertorService;

    @BeforeEach
    void setup() {
        when(britishTimeConvertorService.toBritishSpokenForm(any()))
                .thenReturn("five past two");
    }

    @Test
    void testValidTime() throws Exception {
        mockMvc.perform(get("/api/britishTime")
                        .param("time", "02:05")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.input", is("02:05")))
                .andExpect(jsonPath("$.spoken", is("five past two")));
    }

    @Test
    void testInvalidTimeFormat() throws Exception {
        mockMvc.perform(get("/api/britishTime")
                        .param("time", "invalid")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Invalid time format. Use HH:mm (e.g., 07:35)")));
    }

    @Configuration
    static class TestConfig {
        @Bean
        public BritishTimeConvertorService britishTimeConvertorService() {
            return Mockito.mock(BritishTimeConvertorService.class);
        }
    }
}


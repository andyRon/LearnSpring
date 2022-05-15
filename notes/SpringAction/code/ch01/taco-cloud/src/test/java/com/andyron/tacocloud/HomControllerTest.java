package com.andyron.tacocloud;

import com.andyron.tacocloud.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HomeController.class)
public class HomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomepage() {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isO)

    }
}

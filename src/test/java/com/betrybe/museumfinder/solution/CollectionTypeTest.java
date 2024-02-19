package com.betrybe.museumfinder.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("Test counting museums a specific type: art")
  public void countMuseumsForArt() throws Exception {
    ResultActions result = mockMvc.perform(
        MockMvcRequestBuilders.get("/collections/count/art")
    );

    result.andExpect(MockMvcResultMatchers.jsonPath("$.count").value(123));
  }

  @Test
  @DisplayName("Not found for an unknown type")
  public void notFoundForUnknownType() throws Exception {
    ResultActions result = mockMvc.perform(
        MockMvcRequestBuilders.get("/collections/count/unknown")
    );

    result.andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}

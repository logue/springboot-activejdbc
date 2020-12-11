package dev.logue.app.application.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Testing the API controller.
 *
 * @author logue
 * @version 1.0.0
 * @since 0.0.1
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {
  /** Mock. */
  @Autowired private MockMvc mockMvc;

  /** Test if the CSRF Json array is displayed. */
  @Test
  public void indexActionのテスト() throws Exception {
    this.mockMvc.perform(get("/api")).andDo(print()).andExpect(status().isOk());
  }
}

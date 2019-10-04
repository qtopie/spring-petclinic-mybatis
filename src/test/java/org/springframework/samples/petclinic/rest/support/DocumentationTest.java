package org.springframework.samples.petclinic.rest.support;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;

public class DocumentationTest extends MockMvcBase {

  @Test
  public void docsForwarding() throws Exception {
    mockMvc.perform(get("/docs")).andExpect(status().isOk())
        .andExpect(forwardedUrl("/docs/index.html"));
  }
}

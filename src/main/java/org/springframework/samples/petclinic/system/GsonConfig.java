/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.json.Json;

/** @author qtopierw */
@Configuration
public class GsonConfig {
  @Bean
  public Gson gson() {
    final GsonBuilder builder = new GsonBuilder();
    return builder
        .registerTypeAdapter(Json.class, new SwaggerConfig().new SpringfoxJsonSerializer())
        .create();
  }
}

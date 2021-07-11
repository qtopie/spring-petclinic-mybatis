/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.system;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.json.Json;

/** @author qtopierw */
@Configuration
public class SwaggerConfig {

  class SpringfoxJsonSerializer implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json json, Type typeOfSrc, JsonSerializationContext context) {
      return JsonParser.parseString(json.value());
    }
  }
}

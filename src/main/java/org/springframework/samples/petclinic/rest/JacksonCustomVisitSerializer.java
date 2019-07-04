/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.rest;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.springframework.samples.petclinic.model.Visit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author Vitaliy Fedoriv
 *
 */

public class JacksonCustomVisitSerializer extends StdSerializer<Visit> {

	public JacksonCustomVisitSerializer() {
		this(null);
	}

	protected JacksonCustomVisitSerializer(Class<Visit> t) {
		super(t);
	}

	@Override
	public void serialize(Visit visit, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		if ((visit == null) || (visit.getPetId() == null)) {
			throw new IOException("Cannot serialize Visit object - visit or visit.petId is null");
		}
		Format formatter = new SimpleDateFormat("yyyy/MM/dd");
		jgen.writeStartObject(); // visit
		if (visit.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", visit.getId());
		}
		jgen.writeStringField("date", formatter.format(visit.getDate()));
		jgen.writeStringField("description", visit.getDescription());

		
		if (visit.getPetId() == null) {
          jgen.writeNullField("petId");
        } else {
          jgen.writeNumberField("petId", visit.getPetId());
        }
		jgen.writeEndObject(); // visit
	}

}

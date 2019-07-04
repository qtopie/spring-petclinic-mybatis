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

package org.springframework.samples.petclinic.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.net.HttpHeaders;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Java config for Springfox swagger documentation plugin
 * 
 * @author Vitaliy Fedoriv
 *
 */

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "org.springframework.samples.petclinic.rest")
public class SwaggerConfig {

	public static final String BEARER_API_KEY = "bearer";

	@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo())
				.securitySchemes(Collections.singletonList(apiKey())).securityContexts(
						Collections.singletonList(SecurityContext.builder()
								.securityReferences(Collections.singletonList(SecurityReference.builder()
										.reference(BEARER_API_KEY).scopes(new AuthorizationScope[0]).build()))
								.build()));
	}

	private ApiInfo getApiInfo() {
		final ApiInfo apiInfo = new ApiInfo("REST API",
				new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(""))).lines()
						.collect(Collectors.joining(System.lineSeparator())),
				"1.0.0-RC1", "Petclinic backend terms of service",
				new Contact("artificerpi", "https://github.com/artificerpi/spring-petclinic-mybatis",
						"artificerpi@outlook.com"),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

		return apiInfo;
	}

	private ApiKey apiKey() {
		// `apiKey` is the name of the APIKey,
		// `Authorization` is the key in the request
		// header
		return new ApiKey(BEARER_API_KEY, HttpHeaders.AUTHORIZATION, ApiKeyVehicle.HEADER.getValue());
	}

}

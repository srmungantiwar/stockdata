package com.app.config;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Bean
	public Docket swaggerConfiguration() {
		logger.debug("Configuring Swagger for Application...!!!");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/***"))
				.apis(RequestHandlerSelectors.basePackage("com.app"))
				.build()
				.apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		logger.debug("Creating APIInfo for Swagger...!!!");
		return new ApiInfo(
				"StockData",
				"Stock Data Application To Maintain Records", 
				"1.0", 
				"Free to Use", 
				new Contact("Shashank Mungantiwar","https://creative2brand.com","srmungantiwar1@gmail.com"), 
				"API License",
				"https://creative2brand.com",
				Collections.emptyList());
	}
}

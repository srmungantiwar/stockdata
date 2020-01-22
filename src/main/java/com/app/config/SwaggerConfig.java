package com.app.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
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
		
		//Adding Authorization-Header
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Authorization")
                         .modelRef(new ModelRef("string"))
                         .parameterType("header")
                         .defaultValue("Bearer ")
                         .required(true)                
                         .build();
        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(parameterBuilder.build());
        
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/***"))
				.apis(RequestHandlerSelectors.basePackage("com.app"))
				.build()
				.apiInfo(apiInfo())
				.globalOperationParameters(parameterList);
		
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

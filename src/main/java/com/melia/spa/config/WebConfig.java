package com.melia.spa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${constructed.pools.folder}")
	private String photosFolder;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Map URL path /gallery/** to the physical folder containing images
		registry.addResourceHandler("/gallery/**")
				.addResourceLocations(photosFolder);
	}
}


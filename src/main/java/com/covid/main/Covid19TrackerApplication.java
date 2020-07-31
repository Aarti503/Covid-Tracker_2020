package com.covid.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class Covid19TrackerApplication {

	@Bean
	public RestTemplate getRestTemplate() {

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setReadTimeout(5000);
		return new RestTemplate(clientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(Covid19TrackerApplication.class, args);
	}

}

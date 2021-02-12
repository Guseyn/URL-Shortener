package com.guseyn.urlshortener;

import com.guseyn.urlshortener.service.UrlShortenerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlshortenerApplication {

	public static void main(String[] args) {
		UrlShortenerService.idToShortURL(1);
		SpringApplication.run(UrlshortenerApplication.class, args);

	}

}

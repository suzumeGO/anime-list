package com.registration.anime_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnimeListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeListApplication.class, args);
	}

}

package com.nanofaroque.playingwithdynamodb.playingwithdynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class PlayingwithdynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayingwithdynamodbApplication.class, args);
	}

}

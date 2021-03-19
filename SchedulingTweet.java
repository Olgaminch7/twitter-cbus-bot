package com.olgamelnichenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingTweet {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingTweet.class, args);
	}
}

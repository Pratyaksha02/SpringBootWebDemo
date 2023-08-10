package com.boot.rest.SpringBootWebDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringBootWebDemoApplication {
	Logger logger = Logger.getLogger(SpringBootWebDemoApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDemoApplication.class, args);
	}

	@Autowired
	private IMusicRepository musicRepository;

	@Bean
	public void init() {
		logger.info("ARTIST DATA ADDED");
		musicRepository.save(new Music("6", "Shreya Ghoshal", "Soft music"));
		musicRepository.save(new Music("8", "Divine", "Rap"));
		musicRepository.save(new Music("10", "Atif Aslam", "Soft music"));
		musicRepository.save(new Music("16", "Jubin Nautiyal", "Soft music"));
	}
}
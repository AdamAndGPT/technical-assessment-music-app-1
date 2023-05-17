package com.gaggle.assessment.musicinfo;

import com.gaggle.assessment.musicinfo.data.DataInitializer;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@SpringBootApplication
public class MusicInfoApplication {
	private DataInitializer dataInitializer;

	@PostConstruct
	public void init() {
		dataInitializer.initData();
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicInfoApplication.class, args);
	}

}

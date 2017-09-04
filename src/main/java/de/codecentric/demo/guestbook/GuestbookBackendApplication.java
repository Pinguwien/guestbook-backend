package de.codecentric.demo.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GuestbookBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(GuestbookBackendApplication.class, args);
	}
}

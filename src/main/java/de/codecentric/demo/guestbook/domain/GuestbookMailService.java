package de.codecentric.demo.guestbook.domain;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GuestbookMailService {

	private final GuestbookMailClient mailClient;

	public GuestbookMailService(GuestbookMailClient mailClient) {
		this.mailClient = mailClient;
	}

	@Async
	public void sendMail(final GuestbookEntry entry) {

		System.out.println("Sending Mail...");
		mailClient.sendMail(entry);
		System.out.println("Successfully sent Mail!");

	}
}

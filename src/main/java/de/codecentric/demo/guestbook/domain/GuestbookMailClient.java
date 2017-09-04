package de.codecentric.demo.guestbook.domain;

public interface GuestbookMailClient {

	void sendMail(GuestbookEntry entry);
}

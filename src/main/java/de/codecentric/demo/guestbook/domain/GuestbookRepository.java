package de.codecentric.demo.guestbook.domain;

import java.util.List;

public interface GuestbookRepository {
	List<GuestbookEntry> findAllOrderedByIdDesc();
	GuestbookEntry save(GuestbookEntry entry);
}

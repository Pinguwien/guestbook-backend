package de.codecentric.demo.guestbook.api;

import java.security.Principal;
import java.util.List;

import de.codecentric.demo.guestbook.domain.GuestbookEntry;
import de.codecentric.demo.guestbook.domain.GuestbookMailService;
import de.codecentric.demo.guestbook.domain.GuestbookRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT})
public class GuestbookController {

	private final GuestbookRepository repository;
	
	private final GuestbookMailService mailService;

    public GuestbookController(GuestbookRepository gbRepo, GuestbookMailService mailService) {
        this.repository = gbRepo;
        this.mailService = mailService;
    }

    @GetMapping(value="/guestbook",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEntries(Principal p) {

		List<GuestbookEntry> entries = repository.findAllOrderedByIdDesc();
		
		return ResponseEntity.ok(entries);
	}
	
	@PostMapping(value="/guestbook",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody GuestbookEntry entry) {
		entry = repository.save(entry);
        mailService.sendMail(entry);
		return ResponseEntity.ok(entry);
	}
}

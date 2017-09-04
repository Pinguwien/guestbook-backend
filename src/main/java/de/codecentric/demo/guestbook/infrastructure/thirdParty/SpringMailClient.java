package de.codecentric.demo.guestbook.infrastructure.thirdParty;

import de.codecentric.demo.guestbook.domain.GuestbookEntry;
import de.codecentric.demo.guestbook.domain.GuestbookMailClient;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringMailClient implements GuestbookMailClient {

    private final KeycloakRestTemplate template;

    public SpringMailClient(KeycloakRestTemplate template) {
        this.template = template;
    }
    private final String endpoint = "http://localhost:8082/mail";


    @Override
    public void sendMail(GuestbookEntry entry) {
        Boolean result = template.postForObject(endpoint, entry, Boolean.class);
        System.out.println("Mail sent: " + result.toString());
    }
}

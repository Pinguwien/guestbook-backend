package de.codecentric.demo.guestbook.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SpringJpaGuestbookRepository extends JpaRepository<GuestbookEntity, Long> {

    List<GuestbookEntity> findAllByOrderByIdDesc();
}

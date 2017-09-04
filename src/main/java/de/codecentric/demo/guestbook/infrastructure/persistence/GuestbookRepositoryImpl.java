package de.codecentric.demo.guestbook.infrastructure.persistence;

import de.codecentric.demo.guestbook.domain.GuestbookEntry;
import de.codecentric.demo.guestbook.domain.GuestbookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestbookRepositoryImpl implements GuestbookRepository {

    private final SpringJpaGuestbookRepository springJpaRepository;

    public GuestbookRepositoryImpl(SpringJpaGuestbookRepository springJpaRepository) {
        this.springJpaRepository = springJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GuestbookEntry> findAllOrderedByIdDesc() {
        List<GuestbookEntity> gbEntities = springJpaRepository.findAllByOrderByIdDesc();
        List<GuestbookEntry> results = new ArrayList<>();

        for(GuestbookEntity gbEntity : gbEntities){
            GuestbookEntry gbEntry = new GuestbookEntry();
            gbEntry.setId(gbEntity.getId());
            gbEntry.setComment(gbEntity.getComment());
            gbEntry.setCommenter(gbEntity.getCommenter());
            gbEntry.setDate(gbEntity.getDate());
            gbEntry.setTitle(gbEntity.getTitle());
            results.add(gbEntry);
        }

        return results;
    }

    @Override
    @Transactional
    public GuestbookEntry save(GuestbookEntry entry) {

        GuestbookEntity gbEntity = new GuestbookEntity();
        gbEntity.setComment(entry.getComment());
        gbEntity.setCommenter(entry.getCommenter());
        gbEntity.setDate(entry.getDate());
        gbEntity.setTitle(entry.getTitle());

        springJpaRepository.save(gbEntity);

        return entry;
    }
}

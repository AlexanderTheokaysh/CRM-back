package CRM.repository;

import CRM.domain.LeadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LeadRepository extends JpaRepository<LeadEntity, Long> {

    Optional<LeadEntity> findLeadEntityById(Long id);


    @Query("SELECT l FROM LeadEntity l ORDER BY l.id DESC")
    Page<LeadEntity> getLastRecord(Pageable paging);

}

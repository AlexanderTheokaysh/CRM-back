package CRM.repository;

import CRM.domain.LeadCommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LeadCommentRepository extends CrudRepository<LeadCommentEntity, Long> {
    List<LeadCommentEntity> findLeadCommentEntitiesByLeadId(Long id);
}

package CRM.repository;

import CRM.domain.LeadEntity;
import org.springframework.data.repository.CrudRepository;


public interface LeadCommentRepository extends CrudRepository<LeadEntity, Long> {


}

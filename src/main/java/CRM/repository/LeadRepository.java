package CRM.repository;

import CRM.domain.LeadEntity;
import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<LeadEntity, Long> {


}

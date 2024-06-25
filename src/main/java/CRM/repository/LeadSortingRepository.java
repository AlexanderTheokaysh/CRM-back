package CRM.repository;

import CRM.domain.LeadEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LeadSortingRepository extends PagingAndSortingRepository<LeadEntity, Long> {

    Iterable<LeadEntity> findAll();

}



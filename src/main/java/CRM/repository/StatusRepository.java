package CRM.repository;

import CRM.domain.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity, Integer> {

    Iterable<StatusEntity> findAll();

}



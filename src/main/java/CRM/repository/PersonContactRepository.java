package CRM.repository;

import CRM.domain.PersonContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonContactRepository extends CrudRepository<PersonContactEntity, Long> {
    List<PersonContactEntity> findAllByPersonId(Long id);

}

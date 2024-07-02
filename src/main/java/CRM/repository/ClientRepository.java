package CRM.repository;

import CRM.domain.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

    Page<ClientEntity> findAll(Pageable paging);

}

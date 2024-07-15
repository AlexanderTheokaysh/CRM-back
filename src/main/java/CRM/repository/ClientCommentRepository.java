package CRM.repository;

import CRM.domain.ClientCommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClientCommentRepository extends CrudRepository<ClientCommentEntity, Long> {

    List<ClientCommentEntity> findClientCommentEntitiesByClientId(Long id);

}

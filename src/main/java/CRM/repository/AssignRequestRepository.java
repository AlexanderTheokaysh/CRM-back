package CRM.repository;

import CRM.domain.AssignRequestEntity;
import CRM.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AssignRequestRepository extends CrudRepository<AssignRequestEntity, Long> {

    List<CommentEntity> findAllByLoanId(Long id);


}

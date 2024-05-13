package CRM.repository;

import CRM.domain.AttachedFileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttachedFileRepository extends CrudRepository<AttachedFileEntity, Long> {
    List<AttachedFileEntity> findAllByLoanId(Long id);

}



package CRM.repository;

import CRM.domain.EmployeePositionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends CrudRepository<EmployeePositionEntity, Long> {
}

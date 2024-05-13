package CRM.repository;

import CRM.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findAllByEmployeePositionId(Long Id);


    @Query("SELECT e from EmployeeEntity e " +
            "where e.employeePosition.id= :agentId OR e.employeePosition.id= :analyticId")
    List<EmployeeEntity> findAllByEmployeePosition(Long agentId, Long analyticId);


}

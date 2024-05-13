package CRM.repository.custom;

import CRM.domain.EmployeeEntity;

import java.util.List;

public interface CustomEmployeeRepository {

    List<EmployeeEntity> search(EmployeeEntity fields, Integer limit, Integer offset);
}

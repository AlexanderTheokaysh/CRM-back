package CRM.service;

import CRM.domain.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity get(Long id);

    EmployeeEntity edit(EmployeeEntity entity);

    List<EmployeeEntity> list();

    void delete(Long id);

    List<EmployeeEntity> find(EmployeeEntity employee, Integer limit, Integer offset);

}

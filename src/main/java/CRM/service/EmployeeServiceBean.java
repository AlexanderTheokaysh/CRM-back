package CRM.service;

import CRM.repository.EmployeeRepository;
import CRM.repository.custom.CustomEmployeeRepository;
import CRM.domain.EmployeeEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceBean implements EmployeeService {

    private final CustomEmployeeRepository customEmployeeRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> find(EmployeeEntity employee, Integer limit, Integer offset) {
        return customEmployeeRepository.search(employee, limit, offset);
    }

    @Override
    public EmployeeEntity get(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        return new TemplateUtil<EmployeeEntity>().get(optionalEmployeeEntity);
    }

    @Override
    public EmployeeEntity edit(EmployeeEntity entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public List<EmployeeEntity> list() {
        Iterable<EmployeeEntity> iterableEmployeeEntities = employeeRepository.findAll();
        return new TemplateUtil<EmployeeEntity>().list(iterableEmployeeEntities);
    }


    @Override
    public void delete(Long employeeId) {
        EmployeeEntity employeeEntity = get(employeeId);
        employeeRepository.delete(employeeEntity);
    }
}

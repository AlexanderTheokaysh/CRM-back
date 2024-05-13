package CRM.service;

import CRM.repository.AssignRequestRepository;
import CRM.domain.AssignRequestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignRequestServiceBean implements AssignRequestService {

    private final AssignRequestRepository assignRequestEntity;

    @Override
    public AssignRequestEntity edit(AssignRequestEntity entity) {
        return assignRequestEntity.save(entity);
    }

    @Override
    public void delete(Long id) {
        assignRequestEntity.deleteById(id);
    }
}

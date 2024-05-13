package CRM.service;

import CRM.repository.AssignRequestReasonsRepository;
import CRM.domain.AssignRequestReasonsEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignRequestReasonsServiceBean implements AssignRequestReasonsService {

    private final AssignRequestReasonsRepository assignRequestReasonsRepository;


    @Override
    public AssignRequestReasonsEntity get(Long id) {

        Optional<AssignRequestReasonsEntity> assignRequestReasonsEntityOptional = assignRequestReasonsRepository.findById(id);

        return new TemplateUtil<AssignRequestReasonsEntity>().get(assignRequestReasonsEntityOptional);
    }
}

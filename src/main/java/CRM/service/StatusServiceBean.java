package CRM.service;

import CRM.domain.StatusEntity;
import CRM.repository.StatusRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceBean implements StatusService {

    private final StatusRepository statusRepository;

    @Override
    public List<StatusEntity> list() {

        Iterable<StatusEntity> statusEntities = statusRepository.findAll();
        return new TemplateUtil<StatusEntity>().list(statusEntities);

    }
}



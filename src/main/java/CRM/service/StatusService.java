package CRM.service;

import CRM.domain.StatusEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {

    List<StatusEntity> list();

}

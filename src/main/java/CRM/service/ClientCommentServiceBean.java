package CRM.service;

import CRM.domain.ClientCommentEntity;
import CRM.repository.ClientCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCommentServiceBean implements ClientCommentService {

    @Autowired
    ClientCommentRepository clientCommentRepository;

    @Override
    public ClientCommentEntity get(Long id) {
        return null;
    }

    @Override
    public ClientCommentEntity edit(ClientCommentEntity entity) {
        clientCommentRepository.save(entity);
        return entity;
    }

    @Override
    public ClientCommentEntity delete(ClientCommentEntity entity) {
        clientCommentRepository.deleteById(entity.getId());
        return entity;
    }

    @Override
    public List<ClientCommentEntity> list() {
        return List.of();
    }

    @Override
    public List<ClientCommentEntity> getClientComments(Long id) {
        return clientCommentRepository.findClientCommentEntitiesByClientId(id);
    }

}



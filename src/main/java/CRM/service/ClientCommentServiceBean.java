package CRM.service;

import CRM.domain.ClientCommentEntity;
import CRM.repository.ClientCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCommentServiceBean implements ClientCommentService{


    ClientCommentRepository clientCommentRepository;

    @Override
    public ClientCommentEntity get(Long id) {
        return null;
    }

    @Override
    public ClientCommentEntity edit(ClientCommentEntity entity) {
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

}



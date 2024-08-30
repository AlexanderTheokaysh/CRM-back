package CRM.service;

import CRM.domain.ClientCommentEntity;
import CRM.repository.ClientCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCommentServiceBean implements ClientCommentService {

    private final ClientCommentRepository clientCommentRepository;
    ClientCommentService clientCommentService;

    @Override
    public Long get(Long id) {
        return clientCommentService.get(id);
    }

    @Override
    public ClientCommentEntity edit(ClientCommentEntity entity) {
        clientCommentRepository.save(entity);
        return entity;
    }

    @Override
    public String delete(Long id) {
        clientCommentRepository.deleteById(id);

        return "success";
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



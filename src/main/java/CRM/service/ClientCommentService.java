package CRM.service;

import CRM.domain.ClientCommentEntity;

import java.util.List;

public interface ClientCommentService {

    Long get(Long id);

    ClientCommentEntity edit(ClientCommentEntity entity);

    String delete(Long id);

    List<ClientCommentEntity> list();

    List<ClientCommentEntity> getClientComments(Long id);

}


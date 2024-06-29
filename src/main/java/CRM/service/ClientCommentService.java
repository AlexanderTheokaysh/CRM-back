package CRM.service;

import CRM.domain.ClientCommentEntity;

import java.util.List;

public interface ClientCommentService {

    ClientCommentEntity get(Long id);

    ClientCommentEntity edit(ClientCommentEntity entity);

    ClientCommentEntity delete(ClientCommentEntity entity);

    List<ClientCommentEntity> list();

}


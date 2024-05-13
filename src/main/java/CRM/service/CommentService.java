package CRM.service;

import CRM.domain.CommentEntity;

import java.util.List;

public interface CommentService {
    CommentEntity get(Long id);

    CommentEntity edit(CommentEntity entity);

    List<CommentEntity> list(Long id);

    void delete(Long id);
}





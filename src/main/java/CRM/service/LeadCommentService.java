package CRM.service;

import CRM.domain.LeadCommentEntity;

import java.util.List;

public interface LeadCommentService {

    LeadCommentEntity get(Long id);

    LeadCommentEntity edit(LeadCommentEntity entity);

    List<LeadCommentEntity> list();

}


package CRM.service;

import CRM.domain.LeadCommentEntity;

import java.util.List;

public interface LeadCommentService {

    LeadCommentEntity get(Long id);

    LeadCommentEntity edit(LeadCommentEntity entity);

    LeadCommentEntity delete(LeadCommentEntity entity);

    List<LeadCommentEntity> getLeadComments(Long id);

}


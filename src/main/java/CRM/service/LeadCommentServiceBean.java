package CRM.service;

import CRM.domain.LeadCommentEntity;
import CRM.repository.LeadCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeadCommentServiceBean implements LeadCommentService {

    @Autowired
    LeadCommentRepository leadCommentRepository;

    @Override
    public LeadCommentEntity get(Long id) {
        return null;
    }

    @Override
    public LeadCommentEntity edit(LeadCommentEntity entity) {
        return entity;
    }

    @Override
    public LeadCommentEntity delete(LeadCommentEntity entity) {
        leadCommentRepository.deleteById(entity.getId());
        return entity;
    }

    @Override
    public List<LeadCommentEntity> getLeadComments(Long id) {
        return leadCommentRepository.findLeadCommentEntitiesByLeadId(id);
    }

}



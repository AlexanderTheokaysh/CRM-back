package CRM.service;

import CRM.domain.LeadCommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeadCommentServiceBean implements LeadCommentService {

    @Override
    public LeadCommentEntity get(Long id) {
        return null;
    }

    @Override
    public LeadCommentEntity edit(LeadCommentEntity entity) {
        return entity;
    }

    @Override
    public List<LeadCommentEntity> list() {
        return List.of();
    }

}



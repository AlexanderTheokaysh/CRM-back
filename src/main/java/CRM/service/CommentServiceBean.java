package CRM.service;

import CRM.repository.CommentRepository;
import CRM.domain.CommentEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentServiceBean implements CommentService{

    private final CommentRepository commentRepository;


        @Override
        public CommentEntity get(Long id) {
            Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);
            return new TemplateUtil<CommentEntity>().get(optionalCommentEntity);
        }

        @Override
        public CommentEntity edit(CommentEntity entity) {
            return commentRepository.save(entity);
        }

        @Override
        public List<CommentEntity> list(Long id) {
            return commentRepository.findAllByLoanId(id);
        }

        @Override
        public void delete(Long id) {
            CommentEntity commentEntity = get(id);
            commentRepository.delete(commentEntity);
        }

}



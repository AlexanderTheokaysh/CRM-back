package CRM.controller;

import CRM.domain.LeadCommentEntity;
import CRM.service.LeadCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("leadcomment")
@Slf4j
@RequiredArgsConstructor
public class LeadCommentController {
    LeadCommentService leadCommentService;

    @PostMapping("add")
    public ResponseEntity<LeadCommentEntity> add(@RequestBody LeadCommentEntity comment) {
        comment = leadCommentService.edit(comment);
        return ResponseEntity.ok(comment);
    }

}

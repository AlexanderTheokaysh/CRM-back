package CRM.controller;

import CRM.domain.ClientCommentEntity;
import CRM.service.ClientCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientcomment")
@Slf4j
@RequiredArgsConstructor
public class ClientCommentController {


    @Autowired
    ClientCommentService clientCommentService;

    @PostMapping("add")
    public ResponseEntity<ClientCommentEntity> add(@RequestBody ClientCommentEntity comment) {
        comment = clientCommentService.edit(comment);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("edit")
    public ResponseEntity<ClientCommentEntity> edit(@RequestBody ClientCommentEntity comment) {
        comment = clientCommentService.edit(comment);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("remove")
    public ResponseEntity<ClientCommentEntity> delete(@RequestBody ClientCommentEntity comment) {
        comment = clientCommentService.delete(comment);
        return ResponseEntity.ok(comment);
    }


}

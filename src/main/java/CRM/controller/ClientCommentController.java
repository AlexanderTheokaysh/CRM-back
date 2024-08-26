package CRM.controller;

import CRM.domain.ClientCommentEntity;
import CRM.service.ClientCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get")
    public ResponseEntity<List<ClientCommentEntity>> get(@RequestParam Long id) {
        return ResponseEntity.ok(clientCommentService.getClientComments(id));
    }


    @PostMapping("edit")
    public ResponseEntity<ClientCommentEntity> edit(@RequestBody ClientCommentEntity comment) {
        comment = clientCommentService.edit(comment);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("remove")
    public void delete(@RequestParam Long id) {clientCommentService.delete(clientCommentService.get(id));}


}

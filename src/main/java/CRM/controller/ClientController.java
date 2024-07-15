package CRM.controller;

import CRM.domain.ClientCommentEntity;
import CRM.domain.ClientEntity;
import CRM.service.ClientCommentService;
import CRM.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientCommentService clientCommentService;


    @GetMapping("get")
    @CrossOrigin
    public ResponseEntity<ClientEntity> get(@RequestParam(name = "id") Long loanId) {
        ClientEntity clientEntity = clientService.get(loanId);
        return ResponseEntity.ok(clientEntity);

    }

    @PostMapping("add")
    public ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client) {
        clientService.add(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("edit")
    @CrossOrigin
    public ResponseEntity<ClientEntity> edit(@RequestBody ClientEntity client) {
        List<ClientCommentEntity> comments = clientCommentService.getClientComments(client.getId());
        if (client != null) {
            client.setComments(comments);
        }
        client = clientService.edit(client);

        ClientEntity editedClient = clientService.edit(client);
        return ResponseEntity.ok(editedClient);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Page<ClientEntity>> page(Integer limit, Integer start) {
        Page<ClientEntity> clientEntities = clientService.page(start, limit);
        return ResponseEntity.ok(clientEntities);
    }


}
package CRM.controller;

import CRM.domain.ClientEntity;
import CRM.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("get")
    @CrossOrigin
    public ResponseEntity<ClientEntity> get(@RequestParam(name = "id") Long loanId) {
        ClientEntity clientEntity = clientService.get(loanId);
        return ResponseEntity.ok(clientEntity);

    }

    @PostMapping("add")
    public ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client) {
        client = clientService.edit(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("edit")
    @CrossOrigin
    public ResponseEntity<ClientEntity> edit(@RequestBody ClientEntity client) {


        ClientEntity editedClient = clientService.edit(client);
        return ResponseEntity.ok(editedClient);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Page<ClientEntity>> page(Integer limit, Integer start) {
        Page<ClientEntity> clientEntities = clientService.page(start, limit);
        return ResponseEntity.ok(clientEntities);
    }


}
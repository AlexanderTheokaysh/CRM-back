package CRM.controller;

import CRM.domain.ClientCommentEntity;
import CRM.domain.ClientEntity;
import CRM.service.ClientCommentService;
import CRM.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    @GetMapping("getCountriesFromDB")
    @CrossOrigin
    public ResponseEntity<List<String>> getCountries() {
        return ResponseEntity.ok(clientService.getCountries());
    }


    @SneakyThrows
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Page<ClientEntity>> page(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String lastname,
                                                   @RequestParam(required = false) String uid,
                                                   @RequestParam(required = false) String phone,
                                                   @RequestParam(required = false) String mail,
                                                   @RequestParam(required = false) String affiliation,
                                                   @RequestParam(required = false) String regDateFrom,
                                                   @RequestParam(required = false) String regDateTo,
                                                   @RequestParam(required = false) Integer status,
                                                   @RequestParam(required = false) Integer assignedAgent,
                                                   @RequestParam(required = false) String gender,
                                                   @RequestParam(required = false) String country,
                                                   @RequestParam(required = false) Integer team,
                                                   Integer limit, Integer start) {

        Long convStatus = null;
        Long convAssignedAgent = null;
        Long convTeam = null;
        Date registerDateFrom = null;
        Date registerDateTo = null;

        if (status != null) {
            convStatus = Long.valueOf(status);
        }
        if (assignedAgent != null) {
            convAssignedAgent = Long.valueOf(assignedAgent);
        }
        if (team != null) {
            convTeam = Long.valueOf(team);
        }
        if (regDateFrom != null) {
            registerDateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(regDateFrom);
        }
        if (regDateTo != null) {
            registerDateTo = new SimpleDateFormat("dd/MM/yyyy").parse(regDateTo);

        }

        Page<ClientEntity> clientEntities = clientService.page(name, lastname, uid, phone, mail, affiliation, registerDateFrom, registerDateTo, convStatus, convAssignedAgent, gender, country, convTeam, start, limit);
        return ResponseEntity.ok(clientEntities);
    }

}
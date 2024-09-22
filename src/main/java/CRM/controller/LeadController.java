package CRM.controller;

import CRM.domain.LeadCommentEntity;
import CRM.domain.LeadEntity;
import CRM.service.EmployeeService;
import CRM.service.LeadCommentService;
import CRM.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("lead")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;
    private final LeadCommentService leadCommentService;

    @Autowired
    UserDetailsService userDetailsService;
    private final EmployeeService employeeService;


    @GetMapping("get")
    @CrossOrigin
    public ResponseEntity<LeadEntity> get(@RequestParam(name = "id") Long loanId) {
        LeadEntity loanEntity = leadService.get(loanId);
        return ResponseEntity.ok(loanEntity);

    }

    @PostMapping("add")
    public ResponseEntity<LeadEntity> add(@RequestBody LeadEntity lead) {
        lead = leadService.add(lead);
        return ResponseEntity.ok(lead);
    }

    @PostMapping("edit")
    @CrossOrigin
    public ResponseEntity<LeadEntity> edit(@RequestBody LeadEntity lead) {

        List<LeadCommentEntity> comments = leadCommentService.getLeadComments(lead.getId());

        if (lead != null) {
            lead.setComments(comments);
        }

        lead = leadService.edit(lead);

        LeadEntity editedLead = leadService.edit(lead);
        return ResponseEntity.ok(editedLead);

    }

    @GetMapping("getCountriesFromDB")
    @CrossOrigin
    public ResponseEntity<List<List<String>>> getCountries() {
        return ResponseEntity.ok(leadService.getCountries());
    }



    @SneakyThrows
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Page<LeadEntity>> page(@RequestParam(required = false) String name,
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

        Page<LeadEntity> leadEntities = leadService.page(name, lastname, uid, phone, mail, affiliation, registerDateFrom, registerDateTo, convStatus, convAssignedAgent, gender, country, convTeam, start, limit);
        return ResponseEntity.ok(leadEntities);
    }
}
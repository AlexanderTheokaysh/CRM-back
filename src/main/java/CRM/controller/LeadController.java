package CRM.controller;

import CRM.domain.LeadEntity;
import CRM.service.EmployeeService;
import CRM.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lead")
@Slf4j
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

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
        lead = leadService.edit(lead);
        return ResponseEntity.ok(lead);
    }

    @PostMapping("edit")
    @CrossOrigin
    public ResponseEntity<LeadEntity> edit(@RequestBody LeadEntity lead) {


        LeadEntity editedLead = leadService.edit(lead);
        return ResponseEntity.ok(editedLead);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Page<LeadEntity>> page(Integer limit, Integer start) {
        Page<LeadEntity> leadEntities = leadService.page(start, limit);
        return ResponseEntity.ok(leadEntities);
    }


}
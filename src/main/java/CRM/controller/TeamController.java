package CRM.controller;

import CRM.domain.EmployeeEntity;
import CRM.domain.TeamEntity;
import CRM.service.EmployeeService;
import CRM.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
@Slf4j
@RequiredArgsConstructor

public class TeamController {


    private final TeamService teamService;
    private final EmployeeService employeeService;

    @PostMapping("add")
    public ResponseEntity<TeamEntity> add(@RequestBody TeamEntity team) {
        team = teamService.add(team);
        return ResponseEntity.ok(team);
    }

    @GetMapping("list")
    public ResponseEntity<List<TeamEntity>> list() {
        return ResponseEntity.ok(teamService.list());
    }

    @PostMapping("edit")
    public ResponseEntity<TeamEntity> edit(@RequestBody TeamEntity team) {
        TeamEntity oldTeam = teamService.get(team.getId());
        team.setTeamMembers(oldTeam.getTeamMembers());
        team = teamService.add(team);
        return ResponseEntity.ok(team);
    }

    @GetMapping("addMember")
    public ResponseEntity<TeamEntity> addNewAgentToTeam(@RequestParam Long teamId,
                                                        @RequestParam Long agentId) {
        TeamEntity team = teamService.addAgentToTeam(teamId, agentId);
        return ResponseEntity.ok(team);
    }

    @GetMapping("removeMember")
    public ResponseEntity<EmployeeEntity> removeMember(@RequestParam Long userId) {
        EmployeeEntity emp = employeeService.get(userId);
        emp.setTeamId(null);
        return ResponseEntity.ok(emp);
    }


    @GetMapping("get")
    public ResponseEntity<TeamEntity> getTeam(@RequestParam Long id) {

        return ResponseEntity.ok(teamService.get(id));
    }

//    @PostMapping("remove")
//    public ResponseEntity<LeadCommentEntity> delete(@RequestBody LeadCommentEntity comment) {
//        comment = leadCommentService.delete(comment);
//        return ResponseEntity.ok(comment);
//    }


}

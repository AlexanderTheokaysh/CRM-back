package CRM.controller;

import CRM.domain.DeskEntity;
import CRM.domain.TeamEntity;
import CRM.service.DeskService;
import CRM.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desk")
@Slf4j
@RequiredArgsConstructor

public class DeskController {

    private final DeskService deskService;
    private final TeamService teamService;

    @PostMapping("add")
    public ResponseEntity<DeskEntity> add(@RequestBody DeskEntity desk) {
        desk = deskService.add(desk);
        return ResponseEntity.ok(desk);
    }

    @PostMapping("edit")
    public ResponseEntity<DeskEntity> edit(@RequestBody DeskEntity desk) {
        DeskEntity oldDesk = deskService.get(desk.getId());
        desk.setTeams(oldDesk.getTeams());
        desk = deskService.add(desk);
        return ResponseEntity.ok(desk);
    }

    @GetMapping("addMember")
    public ResponseEntity<DeskEntity> getDesk(@RequestParam Long deskId, @RequestParam Long teamId) {
        DeskEntity desk = deskService.addTeamToDesk(deskId, teamId);
        return ResponseEntity.ok(desk);
    }

    @GetMapping("removeMember")
    public ResponseEntity<TeamEntity> removeMember(@RequestParam Long teamId) {
        TeamEntity team = teamService.get(teamId);
        team.setDeskId(null);
        return ResponseEntity.ok(team);
    }

    @GetMapping("list")
    public ResponseEntity<List<DeskEntity>> list() {
        return ResponseEntity.ok(deskService.list());
    }


    @GetMapping("get")
    public ResponseEntity<DeskEntity> getDesk(@RequestParam Long id) {

        return ResponseEntity.ok(deskService.get(id));
    }


//    @PostMapping("remove")
//    public ResponseEntity<LeadCommentEntity> delete(@RequestBody LeadCommentEntity comment) {
//        comment = leadCommentService.delete(comment);
//        return ResponseEntity.ok(comment);
//    }


}

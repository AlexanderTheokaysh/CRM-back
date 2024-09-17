package CRM.controller;

import CRM.domain.DeskEntity;
import CRM.service.DeskService;
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

    @PostMapping("add")
    public ResponseEntity<DeskEntity> add(@RequestBody DeskEntity desk) {
        desk = deskService.add(desk);
        return ResponseEntity.ok(desk);
    }

    @GetMapping("list")
    public ResponseEntity<List<DeskEntity>> list() {
        return ResponseEntity.ok(deskService.list());
    }


    @GetMapping("get")
    public ResponseEntity<DeskEntity> getDesk(@RequestParam Long id) {

        return ResponseEntity.ok(deskService.get(id));
    }

    @GetMapping("addTeamToDesk")
    public ResponseEntity<DeskEntity> getDesk(@RequestParam Long deskId, @RequestParam Long teamId) {
        DeskEntity desk = deskService.addTeamToDesk(deskId, teamId);
        return ResponseEntity.ok(desk);
    }

//    @PostMapping("remove")
//    public ResponseEntity<LeadCommentEntity> delete(@RequestBody LeadCommentEntity comment) {
//        comment = leadCommentService.delete(comment);
//        return ResponseEntity.ok(comment);
//    }


}

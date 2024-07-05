package CRM.controller;

import CRM.domain.StatusEntity;
import CRM.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("status")
@Slf4j
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @GetMapping("list")
    public ResponseEntity<List<StatusEntity>> list() {
        List<StatusEntity> statusEntities = statusService.list();
        return new ResponseEntity<>(statusEntities, HttpStatus.OK);
    }
}
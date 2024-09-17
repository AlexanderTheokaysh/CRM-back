package CRM.controller;

import CRM.domain.EmployeeEntity;
import CRM.domain.UserEntity;
import CRM.service.EmployeeService;
import CRM.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmployeeService employeeService;

    @GetMapping("get")
    public ResponseEntity<UserEntity> get(@RequestParam Long userId) {
        UserEntity userEntity = userService.get(userId);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }


    @GetMapping("list")
    public ResponseEntity<List<UserEntity>> list() {
        List<UserEntity> userEntities = userService.list();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }


    @GetMapping("add")
    public ResponseEntity<UserEntity> get(@RequestParam String name,
                                          @RequestParam String lastname,
                                          @RequestParam String username,
                                          @RequestParam String mail,
                                          @RequestParam String password) {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName(name)
                .email(mail)
                .lastName(lastname)
                .build();

        employeeEntity = employeeService.edit(employeeEntity);

        UserEntity newUser = UserEntity.builder()
                .username(username)
                .password(password)
                .active(true)
                .createDate(new Date())
                .employeeEntity(employeeEntity)
                .build();


        newUser = userService.createNewUser(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }


}

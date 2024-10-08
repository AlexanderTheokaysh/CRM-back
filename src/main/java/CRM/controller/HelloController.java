package CRM.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping(value = "hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/")
    public String hi() {
        return "<a href='http://localhost:8080/swagger-ui/index.html'>SWAGGER</a>";
    }
}

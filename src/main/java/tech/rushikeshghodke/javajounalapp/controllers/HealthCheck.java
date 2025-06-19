package tech.rushikeshghodke.javajounalapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/test")
    public String test () {
        return "Ok";
    }
}

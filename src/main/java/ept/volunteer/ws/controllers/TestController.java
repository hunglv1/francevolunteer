package ept.volunteer.ws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/frvol/test")
public class TestController {

    @GetMapping("/hello")
    public String allAccess() {
        return "Hello. This is a test Restfull API!";
    }

}
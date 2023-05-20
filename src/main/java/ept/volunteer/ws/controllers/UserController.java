package ept.volunteer.ws.controllers;

import ept.volunteer.ws.models.UserLogin;
import ept.volunteer.ws.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/frvol/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/userList")
    public List<UserLogin> getUserList() {
        return userService.findAllUsers();
    }
}

package com.assessment.sportyshoes.admin;

import com.assessment.sportyshoes.users.User;
import com.assessment.sportyshoes.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/getusers")
    public List<User> getUsers(){
        return userService.getAllUsers();

    }


}

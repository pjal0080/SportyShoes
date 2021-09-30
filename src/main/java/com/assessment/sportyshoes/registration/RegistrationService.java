package com.assessment.sportyshoes.registration;

import com.assessment.sportyshoes.users.User;
import com.assessment.sportyshoes.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }


    public void registerUser(RegistrationRequest request) {

        userService.registerNewUser(new User(

                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNo(),
                request.getUserRole()
        ));

    }
}

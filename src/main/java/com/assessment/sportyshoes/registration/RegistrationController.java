package com.assessment.sportyshoes.registration;

import com.assessment.sportyshoes.users.User;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/register")
    public String registerUserForm(Model model){

        model.addAttribute("form",new RegistrationRequest());
        return "registration";

    }

    @PostMapping(path = "/api/v1/register")
    public String register(Model model, RegistrationRequest request){

       registrationService.registerUser(request);

       return "redirect:/registration_success/";
    }

    @RequestMapping(path = "/registration_success")
    public String registrationSuccess(){

        return "registration_success";
    }

}

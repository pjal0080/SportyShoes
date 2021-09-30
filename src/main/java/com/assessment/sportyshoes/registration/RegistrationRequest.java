package com.assessment.sportyshoes.registration;

import com.assessment.sportyshoes.users.UserRole;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class RegistrationRequest {

    public RegistrationRequest(){

    }

    private  String name;
    private String email;
    private String password;
    private  String phoneNo;

    @Enumerated(EnumType.STRING)
    private  UserRole userRole;

}

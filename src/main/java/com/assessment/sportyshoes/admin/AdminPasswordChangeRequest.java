package com.assessment.sportyshoes.admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminPasswordChangeRequest {

    private String email;
    private String newPassword;

}

package com.github.DominasPL.Giveaway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNameAndRoleDTO {

    private String firstName;
    private String role;

}

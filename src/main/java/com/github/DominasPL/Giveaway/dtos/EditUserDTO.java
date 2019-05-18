package com.github.DominasPL.Giveaway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDTO {


    //TODO WALIDACJA
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String street;

    private String streetNumber;

    private String postalCode;

}

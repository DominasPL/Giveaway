package com.github.DominasPL.Giveaway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDTO {

    private String email;
    private String role;

    @Size(min = 3, max = 30)
    private String firstName;

    @Size(min = 3, max = 30)
    private String lastName;

    @Pattern(regexp="(^$|[0-9]{9})")
    private String phoneNumber;

    @Size(min = 3, max = 30)
    private String street;

    @Pattern(regexp = "([0-9]{1,3})")
    private String streetNumber;

    @Pattern(regexp = ("\\d{2}-\\d{3}"))
    private String postalCode;

}

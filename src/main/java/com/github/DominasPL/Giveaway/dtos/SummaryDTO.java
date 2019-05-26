package com.github.DominasPL.Giveaway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDTO {

    private Long amount;
    private String name;
    private String street;
    private String town;
    private String postalCode;
    private String phoneNumber;
    private String date;
    private String time;
    private String comment;

}

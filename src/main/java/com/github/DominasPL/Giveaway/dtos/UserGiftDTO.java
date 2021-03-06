package com.github.DominasPL.Giveaway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGiftDTO {

    private Long id;
    private Long amount;
    private String institution;
    private String taken;
    private String created;
    private Boolean received;

}




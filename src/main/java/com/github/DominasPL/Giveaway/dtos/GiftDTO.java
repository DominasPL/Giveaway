package com.github.DominasPL.Giveaway.dtos;

import com.github.DominasPL.Giveaway.domain.entities.Address;
import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO {

    //TODO ZROBIC WALIDACJE
    @NotNull
    private Long amount;
    private Location location;
    private Institution institution;
    private String street;
    private String town;
    private String postalCode;
    private String phoneNumber;
    private String comment;
    private List<String> groups;
    private List<String> things;
    //Do odczytu
    private String created;
    private String taken;

}

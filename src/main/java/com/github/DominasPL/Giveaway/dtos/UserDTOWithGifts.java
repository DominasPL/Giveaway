package com.github.DominasPL.Giveaway.dtos;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOWithGifts {

    private List<Gift> gifts;

}

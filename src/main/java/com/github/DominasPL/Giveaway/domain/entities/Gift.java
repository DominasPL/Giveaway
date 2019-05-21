package com.github.DominasPL.Giveaway.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gifts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "insitution_id")
    private Institution institution;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gift_id")
    private List<Thing> things = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gift_id")
    private List<Group> groups = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}

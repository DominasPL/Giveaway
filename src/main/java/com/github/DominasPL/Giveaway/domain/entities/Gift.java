package com.github.DominasPL.Giveaway.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String things;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String supportTo;

    @ManyToOne
    @JoinColumn(name = "insitution_id")
    private Institution institution;

}

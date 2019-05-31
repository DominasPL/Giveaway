package com.github.DominasPL.Giveaway.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Column(nullable = false)
    private String created;

    @Column(nullable = false)
    private String taken;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Boolean received;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "id")
    private Address address;



    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = now.format(formatter);
        this.created = formatDateTime;
    }

}

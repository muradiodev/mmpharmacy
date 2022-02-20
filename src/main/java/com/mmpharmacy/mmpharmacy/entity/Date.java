package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "date")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dateid")
    private int dateid;

    @Column(name = "year")
    private String year;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "date_month",
            joinColumns = @JoinColumn(name = "dateid"),
            inverseJoinColumns = @JoinColumn(name = "monthid"))
    Set<Month> month;

    @Column(name = "day")
    private String day;

}

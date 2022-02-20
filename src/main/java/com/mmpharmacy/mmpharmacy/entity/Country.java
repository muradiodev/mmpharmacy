package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "country")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryid")
    private int countryid;

    @Column(name = "name")
    private String name;

}

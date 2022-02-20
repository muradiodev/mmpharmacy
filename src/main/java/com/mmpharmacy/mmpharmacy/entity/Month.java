package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "month")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monthid")
    private int monthid;

    @Column(name = "name")
    private String name;


}

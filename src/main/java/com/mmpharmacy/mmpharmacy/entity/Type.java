package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "type")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "typeid")
    private int typeid;

    @Column(name = "name")
    private String name;

}

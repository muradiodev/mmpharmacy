package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private int categoryid;

    @Column(name = "name")
    private String name;

}
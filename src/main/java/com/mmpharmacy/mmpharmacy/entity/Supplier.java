package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "supplier")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplierid")
    private int supplierid;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_country",
            joinColumns = @JoinColumn(name = "supplierid"),
            inverseJoinColumns = @JoinColumn(name = "countryid"))
    Country country;

    @Column(name = "address")
    private String address;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "isactive")
    private String isactive;


}

package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
@ToString
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private String year;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "date_month",
            joinColumns = @JoinColumn(name = "date_id"),
            inverseJoinColumns = @JoinColumn(name = "month_id"))
    Set<Month> month;

    @Column(name = "day")
    private String day;

    public Date(int id, String year, Set<Month> month, String day) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<Month> getMonth() {
        return month;
    }

    public void setMonth(Set<Month> month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

package com.example.task15.entity;

import javax.persistence.*;

@Table(name = "manufacture")
@Entity
public class Manufacture {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Manufacture() {}

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}

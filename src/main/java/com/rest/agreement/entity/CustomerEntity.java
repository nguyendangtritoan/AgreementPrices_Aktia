package com.rest.agreement.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull
    private long id;

    @Column(name = "identification_number", nullable = false)
    @NotNull
    private String idNumber;

    @Column(nullable = false)
    @NotNull
    private String name;

    public CustomerEntity(long id, String idNumber, String name) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEntity() {
    }
}

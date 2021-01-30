package com.rest.agreement.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_agreements")
public class AgreementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customerEntity;

    @Column(nullable = false)
    @NotNull
    private int typeAgreement;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date startAgreement;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date endAgreement;

    public AgreementEntity(long id, CustomerEntity customerEntity, int typeAgreement, Date startAgreement, Date endAgreement) {
        this.id = id;
        this.customerEntity = customerEntity;
        this.typeAgreement = typeAgreement;
        this.startAgreement = startAgreement;
        this.endAgreement = endAgreement;
    }

    public AgreementEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public int getTypeAgreement() {
        return typeAgreement;
    }

    public void setTypeAgreement(int typeAgreement) {
        this.typeAgreement = typeAgreement;
    }

    public Date getStartAgreement() {
        return startAgreement;
    }

    public void setStartAgreement(Date startAgreement) {
        this.startAgreement = startAgreement;
    }

    public Date getEndAgreement() {
        return endAgreement;
    }

    public void setEndAgreement(Date endAgreement) {
        this.endAgreement = endAgreement;
    }

}

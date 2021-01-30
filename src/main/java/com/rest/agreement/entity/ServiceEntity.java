package com.rest.agreement.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "agreement_services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name="cus_agree_id")
    @NotNull
    private AgreementEntity agreementEntity;

    @Column(nullable = false)
    private int typeService;

    @Column(nullable = false)
    private BigDecimal feeService;

    public ServiceEntity() {
    }

    public ServiceEntity(long id, AgreementEntity agreementEntity, int typeService, BigDecimal feeService) {
        this.id = id;
        this.agreementEntity = agreementEntity;
        this.typeService = typeService;
        this.feeService = feeService;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AgreementEntity getAgreementEntity() {
        return agreementEntity;
    }

    public void setAgreementEntity(AgreementEntity agreementEntity) {
        this.agreementEntity = agreementEntity;
    }

    public int getTypeService() {
        return typeService;
    }

    public void setTypeService(int typeService) {
        this.typeService = typeService;
    }

    public BigDecimal getFeeService() {
        return feeService;
    }

    public void setFeeService(BigDecimal feeService) {
        this.feeService = feeService;
    }
}

package com.rest.agreement.service;

import com.rest.agreement.entity.AgreementEntity;
import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.repository.AgreementRepo;
import com.rest.agreement.repository.CustomerRepo;
import com.rest.agreement.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AgreementSer {

    private AgreementRepo agreementRepo;
    private CustomerRepo customerRepo;
    private ServiceRepo serviceRepo;

    @Autowired
    public void setAgreementRepo(AgreementRepo agreementRepo) {
        this.agreementRepo = agreementRepo;
    }

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    @Autowired
    public void setServiceRepo(ServiceRepo serviceRepo){
        this.serviceRepo = serviceRepo;
    }

    public AgreementEntity addAgreement(AgreementEntity agreementEntity){

        CustomerEntity customerEntity = customerRepo.findById(agreementEntity.getCustomerEntity().getId()).orElse(null);

        if(customerEntity == null){
            customerRepo.save(agreementEntity.getCustomerEntity());
        }else {
            agreementEntity.setCustomerEntity(customerEntity);
        }
        return agreementRepo.save(agreementEntity);
    }

    public AgreementEntity getAgreementById(long id){
        return agreementRepo.findById(id).orElse(null);
    }

    public List<AgreementEntity> getAgreementByCusId(long customerId){
        return agreementRepo.findByCustomerEntity_IdContaining(customerId);
    }

    public List<AgreementEntity> getAllAgreements(){
        return agreementRepo.findAll();
    }

    public AgreementEntity updateAgreement(AgreementEntity agreementEntity){
        AgreementEntity existingAgreementEntity = agreementRepo.findById(agreementEntity.getId()).orElse(null);
        assert existingAgreementEntity != null;
        existingAgreementEntity.setCustomerEntity(agreementEntity.getCustomerEntity());
        existingAgreementEntity.setStartAgreement(agreementEntity.getStartAgreement());
        existingAgreementEntity.setTypeAgreement(agreementEntity.getTypeAgreement());
        if(agreementEntity.getEndAgreement() != null){
            existingAgreementEntity.setEndAgreement(agreementEntity.getEndAgreement());
        }
        return agreementRepo.save(existingAgreementEntity);
    }

    public String deleteAgreement(long id){

        List<ServiceEntity> serviceEntityList = serviceRepo.findByAgreementEntity_Id(id);
        for(ServiceEntity serviceEntity : serviceEntityList){
            serviceRepo.deleteById(serviceEntity.getId());
        }
        agreementRepo.deleteById(id);
        return "Remove item: "+id;
    }
}

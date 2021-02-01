package com.rest.agreement.service;

import com.rest.agreement.entity.AgreementEntity;
import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.repository.AgreementRepo;
import com.rest.agreement.repository.CustomerRepo;
import com.rest.agreement.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSer {

    private CustomerRepo customerRepo;
    private AgreementRepo agreementRepo;
    private ServiceRepo serviceRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Autowired
    public void setAgreementRepo(AgreementRepo agreementRepo) {
        this.agreementRepo = agreementRepo;
    }
    @Autowired
    public void setServiceRepo(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public CustomerEntity saveCustomer(CustomerEntity customerEntity){
        return customerRepo.save(customerEntity);
    }

    public CustomerEntity getCustomerById(long id){
        return customerRepo.findById(id).orElse(null);
    }

    public CustomerEntity getCustomerByName(String name){
        return customerRepo.findByName(name);
    }

    public List<CustomerEntity> getAllCustomer(){
        return customerRepo.findAll();
    }

    public String deleteCustomer(long id){
        List<AgreementEntity> agreementEntityList = agreementRepo.findByCustomerEntity_IdContaining(id);
        for(AgreementEntity agreementEntity : agreementEntityList){
            for(ServiceEntity serviceEntity : serviceRepo.findByAgreementEntity_Id(agreementEntity.getId())){
                serviceRepo.deleteById(serviceEntity.getId());
            }
            agreementRepo.deleteById(agreementEntity.getId());
        }

        customerRepo.deleteById(id);
        return "Customer with id: "+id+" and reference agreements, services have been removed";
    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity){
        CustomerEntity existingCustomerEntity = customerRepo.findById(customerEntity.getId()).orElse(null);
        assert existingCustomerEntity != null;
        existingCustomerEntity.setIdNumber(customerEntity.getIdNumber());
        existingCustomerEntity.setName(customerEntity.getName());
        return customerRepo.save(existingCustomerEntity);
    }



}

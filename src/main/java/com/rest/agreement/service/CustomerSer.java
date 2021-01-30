package com.rest.agreement.service;

import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSer {

    private CustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
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
        customerRepo.deleteById(id);
        return "Customer removed! "+id;
    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity){
        CustomerEntity existingCustomerEntity = customerRepo.findById(customerEntity.getId()).orElse(null);
        assert existingCustomerEntity != null;
        existingCustomerEntity.setIdNumber(customerEntity.getIdNumber());
        existingCustomerEntity.setName(customerEntity.getName());
        return customerRepo.save(existingCustomerEntity);
    }



}

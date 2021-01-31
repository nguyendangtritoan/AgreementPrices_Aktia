package com.rest.agreement.controller;

import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.service.CustomerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerController {

    private CustomerSer customerSer;

    @Autowired
    public void setCustomerService(CustomerSer customerSer) {
        this.customerSer = customerSer;
    }

    @PostMapping("/customer/save")
    public CustomerEntity addProduct(@RequestBody CustomerEntity customerEntity){
        return customerSer.saveCustomer(customerEntity);
    }

    @GetMapping("/customer/list")
    public List<CustomerEntity> getAllCustomers(){
        return customerSer.getAllCustomer();
    }

    @GetMapping("/customerById/{id}")
    public CustomerEntity getCustomerById(@PathVariable long id){
        return customerSer.getCustomerById(id);
    }

    @GetMapping("/customerByName/{name}")
    public CustomerEntity getCustomerByName(@PathVariable String name){
        return customerSer.getCustomerByName(name);
    }

    @PutMapping("/customer/update")
    public CustomerEntity updateCustomer(@RequestBody CustomerEntity customerEntity){
        return customerSer.updateCustomer(customerEntity);
    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        return customerSer.deleteCustomer(id);
    }

}

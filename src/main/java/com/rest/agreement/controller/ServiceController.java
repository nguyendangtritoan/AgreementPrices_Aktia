package com.rest.agreement.controller;

import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ServiceController {

    private ServiceSer serviceSer;

    @Autowired
    public void setServiceSer(ServiceSer serviceSer){
        this.serviceSer = serviceSer;
    }

    @PostMapping("/service/save")
    public ServiceEntity addService(@RequestBody ServiceEntity serviceEntity){
        return serviceSer.addService(serviceEntity);
    }

    @GetMapping("/serviceById/{id}")
    public ServiceEntity getServiceById(@PathVariable long id){
        return serviceSer.getServiceById(id);
    }

    @GetMapping("/service/list")
    public List<ServiceEntity> getAllServices(){
        return serviceSer.getAllServices();
    }

    @PutMapping("/service/update")
    public ServiceEntity updateService(@RequestBody ServiceEntity serviceEntity){
        return serviceSer.updateService(serviceEntity);
    }

    @DeleteMapping("/service/delete/{id}")
    public String deleteService(@PathVariable long id){
        return serviceSer.removeService(id);
    }

    @GetMapping("/getSumOfFee/{id}")
    public BigDecimal getSumOfFee(@PathVariable long id){
        return serviceSer.getSumOfFee(id);
    }
}

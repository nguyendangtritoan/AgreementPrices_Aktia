package com.rest.agreement.controller;

import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    private ServiceSer serviceSer;

    @Autowired
    public void setServiceSer(ServiceSer serviceSer){
        this.serviceSer = serviceSer;
    }

    @PostMapping("/addService")
    public ServiceEntity addService(@RequestBody ServiceEntity serviceEntity){
        return serviceSer.addService(serviceEntity);
    }

    @GetMapping("/getServiceById/{id}")
    public ServiceEntity getServiceById(@PathVariable long id){
        return serviceSer.getServiceById(id);
    }

    @GetMapping("/services")
    public List<ServiceEntity> getAllServices(){
        return serviceSer.getAllServices();
    }

    @PutMapping("/updateService")
    public ServiceEntity updateService(@RequestBody ServiceEntity serviceEntity){
        return serviceSer.updateService(serviceEntity);
    }

    @DeleteMapping("/deleteService/{id}")
    public String deleteService(@PathVariable long id){
        return serviceSer.removeService(id);
    }
}

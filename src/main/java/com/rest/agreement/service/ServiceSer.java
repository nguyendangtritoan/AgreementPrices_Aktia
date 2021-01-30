package com.rest.agreement.service;

import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSer {

    private ServiceRepo serviceRepo;

    @Autowired
    public void setServiceRepo(ServiceRepo serviceRepo){
        this.serviceRepo = serviceRepo;
    }

    public ServiceEntity addService(ServiceEntity serviceEntity){
        return serviceRepo.save(serviceEntity);
    }

    public ServiceEntity getServiceById(long id){
        return serviceRepo.findById(id).orElse(null);
    }

    public List<ServiceEntity> getAllServices(){
        return serviceRepo.findAll();
    }

    public ServiceEntity updateService(ServiceEntity serviceEntity){
        ServiceEntity existingService = serviceRepo.findById(serviceEntity.getId()).orElse(null);
        if(existingService != null){
            existingService.setTypeService(serviceEntity.getTypeService());
            existingService.setFeeService(serviceEntity.getFeeService());
            existingService.setAgreementEntity(serviceEntity.getAgreementEntity());
            return serviceRepo.save(existingService);
        }
        return null;
    }

    public String removeService(long id){
        serviceRepo.deleteById(id);
        return "Remove service id: " + id;
    }
}

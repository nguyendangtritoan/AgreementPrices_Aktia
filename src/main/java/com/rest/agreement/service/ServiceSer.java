package com.rest.agreement.service;

import com.rest.agreement.entity.AgreementEntity;
import com.rest.agreement.entity.CustomerEntity;
import com.rest.agreement.entity.ServiceEntity;
import com.rest.agreement.repository.AgreementRepo;
import com.rest.agreement.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class ServiceSer {

    private ServiceRepo serviceRepo;
    private AgreementRepo agreementRepo;

    @Autowired
    public void setServiceRepo(ServiceRepo serviceRepo){
        this.serviceRepo = serviceRepo;
    }

    @Autowired
    public void setAgreementRepo(AgreementRepo agreementRepo){
        this.agreementRepo = agreementRepo;
    }

    public ServiceEntity addService(ServiceEntity serviceEntity){
        AgreementEntity agreementEntity = agreementRepo.findById(serviceEntity.getAgreementEntity().getId()).orElse(null);

        if(agreementEntity == null){
            agreementRepo.save(serviceEntity.getAgreementEntity());
        }else {
            serviceEntity.setAgreementEntity(agreementEntity);
        }

        return serviceRepo.save(serviceEntity);
    }

    public ServiceEntity getServiceById(long id){
        return serviceRepo.findById(id).orElse(null);
    }

    public List<ServiceEntity> getAllServices(){
        return serviceRepo.findAll();
    }

    public ServiceEntity updateService(ServiceEntity serviceRecieve){
        //Get from database
        ServiceEntity existingService = serviceRepo.findById(serviceRecieve.getId()).orElse(null);
        if(existingService != null){
            CustomerEntity customerFromDB = existingService.getAgreementEntity().getCustomerEntity();
            AgreementEntity agreementFromDB = existingService.getAgreementEntity();
            //Update Service
            existingService.setTypeService(serviceRecieve.getTypeService());
            existingService.setFeeService(serviceRecieve.getFeeService());

            //Update agreement accordingly
            agreementFromDB.setTypeAgreement(serviceRecieve.getAgreementEntity().getTypeAgreement());
            agreementFromDB.setStartAgreement(serviceRecieve.getAgreementEntity().getStartAgreement());
            agreementFromDB.setEndAgreement(serviceRecieve.getAgreementEntity().getEndAgreement());

            //Update Customer accordingly
            customerFromDB.setIdNumber(serviceRecieve.getAgreementEntity().getCustomerEntity().getIdNumber());
            customerFromDB.setName(serviceRecieve.getAgreementEntity().getCustomerEntity().getName());

            //Set the update
            agreementFromDB.setCustomerEntity(customerFromDB);
            existingService.setAgreementEntity(agreementFromDB);

            return serviceRepo.save(existingService);
        }
        return null;
    }

    public String removeService(long id){
        serviceRepo.deleteById(id);
        return "Remove service id: " + id;
    }


    //Return sum of services fee in agreement
    public BigDecimal getSumOfFee(long agreementId){

        BigDecimal sum = new BigDecimal(BigInteger.ZERO);
        List<ServiceEntity> serviceEntityList = serviceRepo.findByAgreementEntity_Id(agreementId);
        for (ServiceEntity service : serviceEntityList) {
            sum = sum.add(service.getFeeService());
        }

        return sum;
    }
}

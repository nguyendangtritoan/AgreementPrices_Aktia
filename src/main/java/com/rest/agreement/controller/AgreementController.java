package com.rest.agreement.controller;


import com.rest.agreement.entity.AgreementEntity;
import com.rest.agreement.service.AgreementSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AgreementController {

    private AgreementSer agreementSer;

    @Autowired
    public void setAgreementService(AgreementSer agreementSer) {
        this.agreementSer = agreementSer;
    }

    @PostMapping("/agreement/save")
    public AgreementEntity addAgreement(@RequestBody AgreementEntity agreementEntity){
        return agreementSer.addAgreement(agreementEntity);
    }

    @GetMapping("/agreement/list")
    public List<AgreementEntity> getAllAgreements(){
        return agreementSer.getAllAgreements();
    }

    @GetMapping("/agreementById/{id}")
    public AgreementEntity getAgreementById(@PathVariable long id){
        return agreementSer.getAgreementById(id);
    }

    @GetMapping("/agreementByCusId/{id}")
    public List<AgreementEntity> getAgreementByCusId(@PathVariable long id){
        return agreementSer.getAgreementByCusId(id);
    }

    @PutMapping("/agreement/update")
    public AgreementEntity updateAgreement(@RequestBody AgreementEntity agreementEntity){
        return agreementSer.updateAgreement(agreementEntity);
    }

    @DeleteMapping("/agreement/delete/{id}")
    public String deleteAgreement(@PathVariable long id){
        return agreementSer.deleteAgreement(id);
    }
}

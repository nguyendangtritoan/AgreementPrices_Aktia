package com.rest.agreement.repository;

import com.rest.agreement.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<ServiceEntity, Long> {

    @Query("SELECT a from  ServiceEntity a where a.agreementEntity.id = :agreementId")
    List<ServiceEntity> findByAgreementEntity_Id(long agreementId);
}

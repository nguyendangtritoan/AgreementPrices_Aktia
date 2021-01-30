package com.rest.agreement.repository;

import com.rest.agreement.entity.AgreementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgreementRepo extends JpaRepository<AgreementEntity, Long> {

    @Query("SELECT a from  AgreementEntity a where a.customerEntity.id = :customerEntity_id")
    List<AgreementEntity> findByCustomerEntity_IdContaining(long customerEntity_id);
}

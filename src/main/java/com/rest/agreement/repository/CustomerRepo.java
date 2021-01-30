package com.rest.agreement.repository;

import com.rest.agreement.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByName(String name);
}

package com.rest.agreement.repository;

import com.rest.agreement.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<ServiceEntity, Long> {
}

package com._565_567_606_609.airbnb.repository;

import com._565_567_606_609.airbnb.models.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    List<Tenant> findByEmailAndPassword(String email, String password);
}

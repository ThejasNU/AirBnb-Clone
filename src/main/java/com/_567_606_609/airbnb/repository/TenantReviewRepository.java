package com._567_606_609.airbnb.repository;

import com._567_606_609.airbnb.models.TenantReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantReviewRepository extends JpaRepository<TenantReview,Integer> {
    public List<TenantReview> findTenantReviewsByTenantID(Integer tenantId);
}

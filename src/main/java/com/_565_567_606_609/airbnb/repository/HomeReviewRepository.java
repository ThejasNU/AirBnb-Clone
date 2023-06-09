package com._565_567_606_609.airbnb.repository;

import com._565_567_606_609.airbnb.models.HomeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HomeReviewRepository extends JpaRepository<HomeReview,Integer> {
    List<HomeReview> findByHomeID(Integer homeID);

}

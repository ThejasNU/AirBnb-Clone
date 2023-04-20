package com._565_567_606_609.airbnb.repository;

import com._565_567_606_609.airbnb.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Home,Integer> {
    List<Home> findByCity(String city);
    List<Home> findByOwnerid(Integer ownerid);
}

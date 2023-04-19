package com._567_606_609.airbnb.repository;

import com._567_606_609.airbnb.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    List<Owner> findByEmailAndPassword(String email, String password);
}

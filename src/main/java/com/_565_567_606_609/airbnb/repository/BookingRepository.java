package com._565_567_606_609.airbnb.repository;

import com._565_567_606_609.airbnb.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    public List<Booking> findBookingsByTenantID(Integer tenantId);
}

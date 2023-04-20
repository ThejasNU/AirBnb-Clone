package com._565_567_606_609.airbnb.services;

import com._565_567_606_609.airbnb.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TenantService {
    public String signUp(Tenant tenant);
    public Tenant findTenant(String id);
    public List<Home> getAllHomes();
    public String login(LoginFormData loginFormData);
    public void homeReview(HomeReviewFormData homeReviewFormData, Integer tenantID, Integer homeID);
    public Home getRoom(Integer id);
    public List<Home> findHomes(String city);
    public List<HomeReview> findReview(Integer id);
    public void bookStay(BookRoomForm data);
    public List<Booking> getAllBookingsFromTenantID(Integer tenantId);
    public List<TenantReview> getAllTenantReviews(Integer tenantId);
}

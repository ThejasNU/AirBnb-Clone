package com._567_606_609.airbnb.services;

import com._567_606_609.airbnb.models.*;
import com._567_606_609.airbnb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService{

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private HomeReviewRepository homeReviewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TenantReviewRepository tenantReviewRepository;

    @Override
    public String signUp(Tenant tenant) {
        Tenant obj = tenantRepository.save(tenant);
        return Integer.toString(obj.getTenantID());
    }

    @Override
    public Tenant findTenant(String id) {
        return tenantRepository.getById(Integer.parseInt(id));
    }

    @Override
    public List<Home> getAllHomes(){
        return homeRepository.findAll();
    }

    @Override
    public String login(LoginFormData loginFormData) {
//        Integer id = tenantRepository.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        List<Tenant> tenants = tenantRepository.findByEmailAndPassword(loginFormData.getEmail(),loginFormData.getPassword());
        int id = tenants.get(0).getTenantID();
        return Integer.toString(id);
    }

    @Override
    public void homeReview(HomeReviewFormData homeReviewFormData, Integer tenantID, Integer homeID) {
        HomeReview homeReview = new HomeReview();
        homeReview.setHomeID(homeID);
        homeReview.setTenantID(tenantID);
        homeReview.setRating(homeReviewFormData.getRating());
        homeReview.setReview(homeReviewFormData.getReview());
        homeReviewRepository.save(homeReview);
    }

    @Override
    public List<HomeReview> findReview(Integer id){
        List<HomeReview> homeReviews = homeReviewRepository.findByHomeID(id);
        return homeReviews;
    }


    @Override
    public Home getRoom(Integer id) {
        Home home = homeRepository.getById(id);
        return home;
    }

    @Override
    public List<Home> findHomes(String city) {
        List<Home> homes = homeRepository.findByCity(city);
        return homes;
    }

    @Override
    public void bookStay(BookRoomForm data){
        Booking booking=new Booking();
        booking.setTenantID(data.getTenantID());
        booking.setOwnerID(data.getOwnerID());
        booking.setHomeID(data.getHomeID());
        booking.setStartDate(data.getStartDate());
        booking.setEndDate(data.getEndDate());
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookingsFromTenantID(Integer tenantId){
        return bookingRepository.findBookingsByTenantID(tenantId);
    }

    @Override
    public List<TenantReview> getAllTenantReviews(Integer tenantId){
        return tenantReviewRepository.findTenantReviewsByTenantID(tenantId);
    }

}

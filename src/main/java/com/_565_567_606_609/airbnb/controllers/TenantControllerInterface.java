package com._565_567_606_609.airbnb.controllers;

import com._565_567_606_609.airbnb.models.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface TenantControllerInterface{
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public ModelAndView homeReview();
    public ModelAndView viewRoom(Integer homeID);
    public ModelAndView viewRoomReview(Integer homeID);
    public String loginTenant(LoginFormData loginFormData, HttpServletRequest request);
    public String createTenant(Tenant tenant, HttpServletRequest request);
    public String addHomeReview(HomeReviewFormData homeReviewFormData, HttpSession session );
    public String bookRoom(Integer id, Model model,HttpSession session);
    public String addBooking(BookRoomForm data);
    public ModelAndView searchResults(SearchByCity city, HttpSession session);
}

package com._567_606_609.airbnb.controllers;

import com._567_606_609.airbnb.models.Home;
import com._567_606_609.airbnb.models.LoginFormData;
import com._567_606_609.airbnb.models.Owner;
import com._567_606_609.airbnb.models.TenantReview;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface OwnerControllerInterface {
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public String loginOwner(LoginFormData loginFormData, HttpServletRequest request);
    public ModelAndView tenantReview();
    public String createOwner(Owner owner, HttpServletRequest request);
    public String addTenantReview(TenantReview tenantReview,HttpSession session);
    public ModelAndView addHome();
    public String addHomeData(Home home, HttpSession session);
}

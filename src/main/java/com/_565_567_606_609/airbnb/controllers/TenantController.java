package com._565_567_606_609.airbnb.controllers;

import com._565_567_606_609.airbnb.models.*;
import com._565_567_606_609.airbnb.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tenant")
public class TenantController implements TenantControllerInterface{

    @Autowired
    private TenantService tenantService;

    @GetMapping({"/","/login"})
    @Override
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("tenantLogin");
        LoginFormData loginFormData = new LoginFormData();
        mav.addObject("loginFormData",loginFormData);
        return mav;
    }

    @GetMapping("/signup")
    @Override
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView("tenantSignUp");
        Tenant tenant = new Tenant();
        mav.addObject("tenant",tenant);
        return mav;
    }

    @GetMapping("/dashboard")
    @Override
    public ModelAndView dashboard( HttpSession session){
        ModelAndView mav = new ModelAndView("tenantDashboard");
        String id = (String) session.getAttribute("TENANT_ID");
        Integer tenantId=Integer.parseInt(id);
        Tenant tenant = tenantService.findTenant(id);
        SearchByCity searchByCity=new SearchByCity();
        List<Booking> userBookings=tenantService.getAllBookingsFromTenantID(tenantId);
        List<TenantReview> reviews=tenantService.getAllTenantReviews(tenantId);
        mav.addObject("searchByCity",searchByCity);
        mav.addObject("tenant",tenant);
        mav.addObject("userBookings",userBookings);
        mav.addObject("reviews",reviews);
        return mav;
    }

    @GetMapping("/homeReview")
    @Override
    public ModelAndView homeReview(){
        List<Home> homes=tenantService.getAllHomes();
        ModelAndView mav = new ModelAndView("homeReview");
        HomeReviewFormData homeReviewFormData = new HomeReviewFormData();
        mav.addObject("reviewFormData", homeReviewFormData);
        mav.addObject("homes",homes);
        return mav;
    }

    @GetMapping("/viewRoom")
    @Override
    public ModelAndView viewRoom(@RequestParam(value="id") Integer homeID){
        ModelAndView mav = new ModelAndView("roomDetails");
        BookRoomForm bookRoomForm = new BookRoomForm();
        Home home = tenantService.getRoom(homeID);
        List<HomeReview> homeReviews = tenantService.findReview(homeID);
        System.out.println(homeReviews);
        mav.addObject("bookRoomForm", bookRoomForm);
        mav.addObject("home",home);
        return mav;
    }

    @Override
    @GetMapping("/seeReviews")
    public ModelAndView viewRoomReview(@RequestParam(value="id") Integer homeID) {
        List<HomeReview> homereviews=tenantService.findReview(homeID);
        ModelAndView mav = new ModelAndView("viewHomeReviews");
        mav.addObject("homereviews",homereviews);
        return mav;
    }

    @Override
    @GetMapping("/searchResults")
    public ModelAndView searchResults(@ModelAttribute SearchByCity searchByCity, HttpSession session) {
        List<Home> homes=tenantService.findHomes(searchByCity.getCity());
        ModelAndView mav = new ModelAndView("SearchCityResults");
        mav.addObject("homes",homes);
        return mav;
    }

    @PostMapping(value = "/loginTenant")
    @Override
    public String loginTenant(@ModelAttribute LoginFormData loginFormData, HttpServletRequest request){
        String id = tenantService.login(loginFormData);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/createTenant")
    @Override
    public String createTenant(@ModelAttribute Tenant tenant, HttpServletRequest request){
        String id = tenantService.signUp(tenant);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }


    @PostMapping("/homeReview")
    @Override
    public String addHomeReview(@ModelAttribute HomeReviewFormData homeReviewFormData,HttpSession session ){
        Integer tenantID =Integer.parseInt ((String) session.getAttribute("TENANT_ID"));
        Integer homeId=homeReviewFormData.getHomeID();
        Home home=tenantService.getRoom(homeId);
        homeReviewFormData.setOwnerID(home.getOwnerid());
        tenantService.homeReview(homeReviewFormData,tenantID, homeReviewFormData.getHomeID());
        return "redirect:/tenant/dashboard";
    }

    @Override
    @GetMapping ("/bookRoom/{homeId}")
    public String bookRoom(@PathVariable("homeId") Integer id, Model model,HttpSession session) {
        Home home=tenantService.getRoom(id);
        Integer tenantID =Integer.parseInt ((String) session.getAttribute("TENANT_ID"));
        BookRoomForm bookRoomForm=new BookRoomForm();
        bookRoomForm.setTenantID(tenantID);
        bookRoomForm.setHomeID(home.getHomeID());
        bookRoomForm.setOwnerID(home.getOwnerid());
        model.addAttribute("home",home);
        model.addAttribute("bookRoomForm",bookRoomForm);
        return "roomDetails";
    }

    @Override
    @PostMapping("/addBooking")
    public String addBooking(@ModelAttribute BookRoomForm data){
        tenantService.bookStay(data);
        return "redirect:/tenant/dashboard";
    }
}

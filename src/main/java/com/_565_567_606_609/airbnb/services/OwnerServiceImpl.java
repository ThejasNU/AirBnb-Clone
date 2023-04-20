package com._565_567_606_609.airbnb.services;

import com._565_567_606_609.airbnb.models.*;
import com._565_567_606_609.airbnb.repository.HomeRepository;
import com._565_567_606_609.airbnb.repository.OwnerRepository;
import com._565_567_606_609.airbnb.repository.TenantRepository;
import com._565_567_606_609.airbnb.repository.TenantReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantReviewRepository tenantReviewRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public String signUp(Owner owner) {
        Owner obj = ownerRepository.save(owner);
        return Integer.toString(obj.getOwnerID());
    }

    @Override
    public Owner findOwner(String id) {
        return ownerRepository.getById(Integer.parseInt(id));
    }

    @Override
    public String login(LoginFormData loginFormData) {
        List<Owner> owners = ownerRepository.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        int id = owners.get(0).getOwnerID();
        return Integer.toString(id);
    }


    public void tenantReview(TenantReview tenantReview, Integer ownerID, Integer tenantID){
        tenantReview.setTenantID(tenantID);
        tenantReview.setOwnerID(ownerID);
        tenantReviewRepository.save(tenantReview);
    }

    @Override
    public void addHome(Home home, String id) {
        Integer ownerID = Integer.parseInt(id);
        Owner owner = ownerRepository.getById(ownerID);
        home.setOwnerid(ownerID);
        List<Home> homes = owner.getHomes();
        homes.add(home);
        owner.setHomes(homes);
        ownerRepository.save(owner);
    }

    @Override
    public List<Tenant> getAllTenants(){
        return tenantRepository.findAll();
    }

    @Override
    public List<Home> getAllHomeOfOwner(Integer ownerId){
        return homeRepository.findByOwnerid(ownerId);
    }
}

package com._565_567_606_609.airbnb.services;

import com._565_567_606_609.airbnb.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    public String signUp(Owner owner);
    public Owner findOwner(String id);
    public String login(LoginFormData loginFormData);
    public void tenantReview(TenantReview tenantReview, Integer ownerID, Integer tenantID);
    public void addHome(Home home, String  id);
    public List<Tenant> getAllTenants();
    public List<Home> getAllHomeOfOwner(Integer ownerId);
}

package com._565_567_606_609.airbnb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tenantReview")
public class TenantReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tenantReviewID;
    private int ownerID;
    private int tenantID;
    private double rating;
    private String review;
}


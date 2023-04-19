package com._567_606_609.airbnb.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="booking")
public class Booking {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer bookingID;
    @Column(name="homeid",nullable = false)
    private Integer homeID;
    @Column(name="ownerid",nullable = false)
    private Integer ownerID;
    @Column(name="tenantID",nullable = false)
    private Integer tenantID;
    @Column(name="startdate",nullable = false)
    private Date startDate;
    @Column(name="enddate",nullable = false)
    private Date endDate;
}

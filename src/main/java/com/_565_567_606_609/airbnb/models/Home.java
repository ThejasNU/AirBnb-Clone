package com._565_567_606_609.airbnb.models;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="home")
public class Home {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int homeID;
    @Column(name="ownerid")
    private int ownerid;
    @Column(name="homename")
    private String homeName;
    @Column(name="price")
    private double price;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="country")
    private String country;
    @Column(name="pin")
    private String pin;
}

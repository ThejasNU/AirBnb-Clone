package com._565_567_606_609.airbnb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="owner")
public class Owner {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer ownerID;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name="phonenumber",nullable = false)
    private String phone;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password",nullable = false)
    private String password;
    @OneToMany(targetEntity = Home.class,cascade = CascadeType.ALL)
    @JoinColumn(name="ownerID_fk",referencedColumnName = "ownerID")
    private List<Home> homes;
}

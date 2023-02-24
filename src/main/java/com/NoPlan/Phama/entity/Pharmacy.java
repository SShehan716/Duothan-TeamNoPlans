package com.NoPlan.Phama.entity;

import lombok.*;

import javax.persistence.ForeignKey;
import javax.persistence.Id;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity()
public class Pharmacy {

    @Id
    private String pharmacyLicence;
    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyMobile;
    private String pharmacyEmail;
    private String pharmacyWebsite;
    private String pharmacyOpeningHours;



}

package com.NoPlan.Phama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class PharmacyDto {
    private String pharmacyLicence;
    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyMobile;
    private String pharmacyEmail;
    private String pharmacyWebsite;
    private String pharmacyOpeningHours;

}

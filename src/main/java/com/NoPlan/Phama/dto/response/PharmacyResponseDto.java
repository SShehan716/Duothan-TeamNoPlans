package com.NoPlan.Phama.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class PharmacyResponseDto {
    private String pharmacyLicence;
    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyMobile;
    private String pharmacyEmail;
    private String pharmacyWebsite;
    private String pharmacyOpeningHours;

}

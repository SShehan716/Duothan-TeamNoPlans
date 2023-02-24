package com.NoPlan.Phama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class DrugDto {
    private String name;
    //@Column (name="Full Name") => change column name to Full name
    private String manufacturer;
    private String supplier;
    private String NDC;
    private Date expirationDate;
    private int qty;
    private double unitPrice;
}

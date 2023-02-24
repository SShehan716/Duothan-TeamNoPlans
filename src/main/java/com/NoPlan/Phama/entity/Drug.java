package com.NoPlan.Phama.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity ()
public class Drug {

    @Id
    private String name;
    //@Column (name="Full Name") => change column name to Full name
    private String manufacturer;
    private String supplier;
    private String NDC;
    private Date expirationDate;
    private int qty;
    private double unitPrice;

}

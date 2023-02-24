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
public class User {

    @Id
    private String ownerId;
    private String ownerName;
    private String ownerAddress;
    private String ownerNumber;
    private String ownerEmail;

}

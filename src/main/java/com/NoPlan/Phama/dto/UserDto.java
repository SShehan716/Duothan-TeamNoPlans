package com.NoPlan.Phama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class UserDto {
    private String ownerId;
    private String ownerName;
    private String ownerAddress;
    private String ownerNumber;
    private String ownerEmail;
}

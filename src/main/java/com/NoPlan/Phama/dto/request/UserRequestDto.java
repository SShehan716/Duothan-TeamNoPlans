package com.NoPlan.Phama.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class UserRequestDto {
    private String ownerId;
    private String ownerName;
    private String ownerAddress;
    private String ownerNumber;
    private String ownerEmail;
}

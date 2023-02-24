package com.NoPlan.Phama.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@NoArgsConstructor
@Data // @Data ====> @Getter , @Setter , @Hashcode , @ToString, @Equals
public class UserResponseDto {
    private String ownerId;
    private String ownerName;
    private String ownerAddress;
    private String ownerNumber;
    private String ownerEmail;

}

package com.NoPlan.Phama.dto.response.paginate;

import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.dto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedUserResponseDto {
    private long dataCount;
    private List<UserResponseDto> dataList;
}

package com.NoPlan.Phama.util.mapper;

import com.NoPlan.Phama.dto.PharmacyDto;
import com.NoPlan.Phama.dto.UserDto;
import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.dto.response.UserResponseDto;
import com.NoPlan.Phama.entity.Pharmacy;
import com.NoPlan.Phama.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto dto);
    UserResponseDto toUserResponseDto(User user);
    List<UserResponseDto> toUserResponseDtoList(List<User> list );
}

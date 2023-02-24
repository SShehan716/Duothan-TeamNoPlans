package com.NoPlan.Phama.service;

import com.NoPlan.Phama.dto.request.UserRequestDto;
import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.dto.response.UserResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedPharmacyResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedUserResponseDto;

public interface UserService {
    String saveUser(UserRequestDto dto);
    UserResponseDto findUser(String name) throws ClassNotFoundException;
    public String updateUser(UserRequestDto dto , String id) throws ClassNotFoundException;
    public String deleteUser(String id);
    public PaginatedUserResponseDto findAllUser(
            String searchText,int page, int size
    );

}

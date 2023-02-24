package com.NoPlan.Phama.service.impl;

import com.NoPlan.Phama.dto.UserDto;
import com.NoPlan.Phama.dto.request.UserRequestDto;
import com.NoPlan.Phama.dto.response.UserResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedUserResponseDto;
import com.NoPlan.Phama.entity.User;
import com.NoPlan.Phama.repo.UserRepo;
import com.NoPlan.Phama.service.UserService;
import com.NoPlan.Phama.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String saveUser(UserRequestDto dto) {
        UserDto cDto  = new UserDto(
                dto.getOwnerId(),
                dto.getOwnerName(),
                dto.getOwnerAddress(),
                dto.getOwnerNumber(),
                dto.getOwnerEmail()
                );

       return userRepo.save(userMapper.toUser(cDto)).getOwnerName() + " Saved!";


    }

    @Override
    public UserResponseDto findUser(String id) throws ClassNotFoundException {

        Optional<User> selectedUser = userRepo.findById(id);
        if(selectedUser.isPresent()){
            return userMapper.toUserResponseDto(selectedUser.get());
        }
        throw new ClassNotFoundException("Not Found");

    }



    @Override
    public String updateUser(UserRequestDto dto, String id) throws ClassNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){

            user.get().setOwnerId(dto.getOwnerId());
            user.get().setOwnerName(dto.getOwnerName());
            user.get().setOwnerAddress(dto.getOwnerAddress());
            user.get().setOwnerNumber(dto.getOwnerNumber());
            user.get().setOwnerEmail(dto.getOwnerEmail());


            userRepo.save(user.get());
            return user.get().getOwnerName()+" was Saved";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteUser(String id) {
        userRepo.deleteById(id);
        return id+" was deleted!";
    }

    @Override
    public PaginatedUserResponseDto findAllUser(
            String searchText, int page, int size
    ) {

        return new PaginatedUserResponseDto(
                userRepo.countUser(searchText),
                userMapper.toUserResponseDtoList(userRepo.searchUser(
                        searchText,  PageRequest.of(page, size)
                ))
        );
    }
}

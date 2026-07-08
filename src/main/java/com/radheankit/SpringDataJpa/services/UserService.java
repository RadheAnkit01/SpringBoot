package com.radheankit.SpringDataJpa.services;


import com.radheankit.SpringDataJpa.dto.CreateUserDto;
import com.radheankit.SpringDataJpa.dto.UserDto;
import com.radheankit.SpringDataJpa.entities.User;
import com.radheankit.SpringDataJpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserDto saveUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public List<UserDto> getUsers() {
        List<User> users= userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            UserDto userDto = new UserDto(user.getId(),user.getName(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

}

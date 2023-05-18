package com.example.editest.Service;

import com.example.editest.DTO.AddUserDTO;
import com.example.editest.DTO.ResponseUserDTO;
import com.example.editest.DTO.UpdateUserDTO;
import com.example.editest.Models.User;
import com.example.editest.Repository.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public ResponseUserDTO AddUser(AddUserDTO request){
        User newUser = userDAO.save(new User(request));
        return new ResponseUserDTO(newUser);
    }

    public ResponseUserDTO UpdateUser(int userId, UpdateUserDTO request){
        User user = userDAO.getOne(userId);
        user.ApplyUpdate(request);
        User updatedUser = userDAO.save(user);
        return new ResponseUserDTO(updatedUser);
    }

    public List<ResponseUserDTO> GetAllUser(Integer userId){
        List<User> users;
        if (userId == 0){
            users = userDAO.findAll();
        }else{
            users = userDAO.findAllById(Collections.singleton(userId));
        }
        return users.stream().map(new Function<User, ResponseUserDTO>() {
            @Override
            public ResponseUserDTO apply(User user) {
                return new ResponseUserDTO(user);
            }
        }).collect(Collectors.toList());
    }

    public List<ResponseUserDTO> DeleteUser(int userId){
        User user = userDAO.getOne(userId);
        userDAO.delete(user);
        List<User> users = userDAO.findAll();
        return users.stream().map(new Function<User, ResponseUserDTO>() {
            @Override
            public ResponseUserDTO apply(User user) {
                return new ResponseUserDTO(user);
            }
        }).collect(Collectors.toList());
    }
}

package com.example.editest.Controller;

import com.example.editest.DTO.AddUserDTO;
import com.example.editest.DTO.ResponseUserDTO;
import com.example.editest.DTO.UpdateUserDTO;
import com.example.editest.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("add-user")
    public ResponseUserDTO SetDataUser(@RequestBody AddUserDTO request){
        return userService.AddUser(request);
    }

    @PutMapping("update-user/{userId}")
    public ResponseUserDTO UpdateDataUser(@RequestBody UpdateUserDTO request, @PathVariable("userId") int userId){
        return userService.UpdateUser(userId, request);
    }

    @GetMapping("users")
    public List<ResponseUserDTO> GetDataUser(@RequestParam(required = false) Integer userId){
        if (userId == null) userId = 0;
        return userService.GetAllUser(userId);
    }

    @DeleteMapping("delete-user/{userId}")
    public List<ResponseUserDTO> DelDataUser(@PathVariable int userId){
        return userService.DeleteUser(userId);
    }
}

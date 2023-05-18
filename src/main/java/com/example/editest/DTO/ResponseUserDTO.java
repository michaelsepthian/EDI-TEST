package com.example.editest.DTO;

import com.example.editest.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserDTO {

    private Integer userId;
    private String namaLengkap;
    private String username;
    private String password;
    private char status;

    public ResponseUserDTO(User user){
        this.userId = user.getId();
        this.namaLengkap = user.getNamaLengkap();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.status = user.getStatus();
    }
}

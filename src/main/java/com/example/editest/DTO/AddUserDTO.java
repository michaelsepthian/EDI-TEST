package com.example.editest.DTO;

import com.example.editest.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserDTO {
    private String namaLengkap;
    private String username;
    private String password;
    private char status;
}

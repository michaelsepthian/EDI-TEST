package com.example.editest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
    private String namaLengkap;
    private String username;
    private String password;
    private char status;
}

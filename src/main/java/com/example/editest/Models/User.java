package com.example.editest.Models;

import com.example.editest.DTO.AddUserDTO;
import com.example.editest.DTO.UpdateUserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tbl_user")
@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "user_id_seq", allocationSize = 1)
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_gen"
    )
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private char status;

    public User(AddUserDTO newUser){
        this.namaLengkap = newUser.getNamaLengkap();
        this.username = newUser.getUsername();
        this.password = newUser.getPassword();
        this.status = newUser.getStatus();
    }

    public void ApplyUpdate(UpdateUserDTO updateUser){
        this.namaLengkap = updateUser.getNamaLengkap() == null ? this.namaLengkap : updateUser.getNamaLengkap();
        this.username = updateUser.getUsername() == null ? this.username : updateUser.getUsername();
        this.password = updateUser.getPassword() == null ? this.password : updateUser.getPassword();
        this.status = updateUser.getStatus() == 0 ? this.status : updateUser.getStatus();
    }
}

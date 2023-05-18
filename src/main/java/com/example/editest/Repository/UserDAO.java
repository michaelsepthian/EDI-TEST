package com.example.editest.Repository;

import com.example.editest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}

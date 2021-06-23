package com.jordan.chango.Api.repositories;

import com.jordan.chango.Api.entities.UserPayroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPayroll,Integer> {
    Optional<UserPayroll> findUserByEmail(String email);
}

package com.example.coursework.repository;


import com.example.coursework.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

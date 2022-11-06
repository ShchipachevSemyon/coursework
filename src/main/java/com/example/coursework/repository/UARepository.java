package com.example.coursework.repository;

import com.example.coursework.entity.UserActions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UARepository extends JpaRepository<UserActions, Long> {
}

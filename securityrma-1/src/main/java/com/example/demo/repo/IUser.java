package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface IUser extends JpaRepository<User, Long>{

	 Optional<User> findByUsername(String log);
}

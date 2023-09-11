package com.smm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smm.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

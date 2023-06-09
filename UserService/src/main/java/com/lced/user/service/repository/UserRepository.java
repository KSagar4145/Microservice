package com.lced.user.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lced.user.service.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

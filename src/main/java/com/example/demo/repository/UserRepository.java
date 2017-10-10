package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findOneByEmail(String email);
}

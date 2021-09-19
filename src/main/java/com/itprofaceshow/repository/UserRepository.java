package com.itprofaceshow.repository;

import com.itprofaceshow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity getByToken(String token);
}

package com.zolochevskyi.dao;

import com.zolochevskyi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
package com.dan_walker_cs.spring_accounts.accounts.repository;

import com.dan_walker_cs.spring_accounts.accounts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This class provides the use of JpaRepository class functions and specifies the relationship.
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}

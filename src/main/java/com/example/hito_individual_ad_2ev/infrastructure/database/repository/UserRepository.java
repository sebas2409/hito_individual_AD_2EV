package com.example.hito_individual_ad_2ev.infrastructure.database.repository;

import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}

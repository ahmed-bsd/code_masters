package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.TokenResetpwd;

import java.util.Optional;

///****    Developped by Ahmed bsd    ****////
@Repository
public interface TokenResetRepository extends JpaRepository<TokenResetpwd, Long> {


    Optional<TokenResetpwd> findByToken(String token);
}

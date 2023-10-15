package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.TokenConfirmation;

import java.util.Optional;

///****    Developped by Ahmed bsd    ****////
@Repository
public interface TokenConfirmRepository extends JpaRepository<TokenConfirmation, Long> {


    Optional<TokenConfirmation> findByToken(String token);

}

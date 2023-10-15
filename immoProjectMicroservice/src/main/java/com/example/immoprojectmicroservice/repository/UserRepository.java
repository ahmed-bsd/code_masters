package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.immoprojectmicroservice.entities.Role;
import com.example.immoprojectmicroservice.entities.UserA;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

///****    Developped by Ahmed bsd    ****////
@Repository
public interface UserRepository extends JpaRepository<UserA, Long> {

    List<UserA> findAllByRoleIsLike(Role r);

    Optional<UserA> findByUserName(String userName);
    Optional<UserA> findByEmail(String email);

    List<UserA> findByBannedUntilBefore(LocalDateTime dateTime);

    List<UserA>  findByArchivedUntilAfter(LocalDateTime dateTime);
    List<UserA>  findByArchivedUntilBefore(LocalDateTime dateTime);

    Optional<List<UserA>> findAllByRoleIs(String role);

    @Transactional
    @Modifying
    @Query("UPDATE UserA a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

}

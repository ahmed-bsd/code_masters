package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.Announce;

import java.util.List;


@Repository
public interface AnnouceRepository extends JpaRepository<Announce, Long> {

    List<Announce> findAnnouncementsBySponsoredIsTrueOrderBySponsoringWeightDesc();



}

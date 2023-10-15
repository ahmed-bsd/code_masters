package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.SponsoringPlan;


@Repository
public interface SponsoringPlanRepository extends JpaRepository<SponsoringPlan, Long> {



}

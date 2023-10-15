package com.example.immoprojectmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.immoprojectmicroservice.entities.AnnouncementViewer;


@Repository
public interface AnnouncementViewerRepository extends JpaRepository<AnnouncementViewer, Long> {


}

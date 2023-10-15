package com.example.immoprojectmicroservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.immoprojectmicroservice.entities.Announce;
import com.example.immoprojectmicroservice.entities.AnnouncementViewer;
import com.example.immoprojectmicroservice.entities.UserA;
import com.example.immoprojectmicroservice.repository.AnnouceRepository;
import com.example.immoprojectmicroservice.repository.AnnouncementViewerRepository;
import com.example.immoprojectmicroservice.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

///****    Developped by Ahmed bsd    ****////
@Service
@Slf4j
public class ViewsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AnnouncementViewerRepository announcementViewerRepository;

	@Autowired
    AnnouceRepository annouceRepository;

	@Autowired
	private AnnouceRepository announcementRepository;


	@Transactional
	public String addView(Long announcementId, Principal principal) {

		// verification
		Announce announcement = announcementRepository.findById(announcementId)
				.orElseThrow(() -> new EntityNotFoundException("Announcement not found"));

		UserA user = userRepository.findByUserName(principal.getName())
				.orElseThrow(() -> new EntityNotFoundException("User not found"));

		// chercher si l'utilisateur a déja vue l'annonce
		List<AnnouncementViewer> announcementViewers=announcementViewerRepository.findAll();
		for(AnnouncementViewer v:announcementViewers){
			if (v.getAnnouncement()==announcement && v.getUser() ==user){
				return "already seen";
			}
		}
        AnnouncementViewer viewer=new AnnouncementViewer(announcement,user);
		announcementViewerRepository.save(viewer);
		return "new view is added";
	}

}
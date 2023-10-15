package com.example.immoprojectmicroservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.immoprojectmicroservice.entities.Announce;
import com.example.immoprojectmicroservice.entities.SponsoringPlan;
import com.example.immoprojectmicroservice.repository.AnnouceRepository;
import com.example.immoprojectmicroservice.repository.SponsoringPlanRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

///****    Developped by Ahmed bsd    ****////
@Service
@Slf4j
public class SponsoringService {

	@Autowired
	SponsoringPlanRepository sponsoringPlanRepository;

	@Autowired
	AnnouceRepository annouceRepository;


	@Transactional
	public String CreateAndAffectSponsoringPlanToAnnouncement(Long announcement_id, SponsoringPlan sponsoringPlan) {




		// verification
		Announce announcement = annouceRepository.findById(announcement_id)
				.orElseThrow(() -> new EntityNotFoundException("Announcement not found"));
		// add my sponsor plan and affect it
		SponsoringPlan sp=sponsoringPlanRepository.saveAndFlush(sponsoringPlan);
		announcement.setSponsored(true);
		annouceRepository.save(announcement);
		sp.setAnnouncement(announcement);
		sponsoringPlanRepository.save(sp);

		return "new sponsoring plan is added";
	}

	public Long getSponsoredAnnouncement() {
		//Page<Announcement> announcements = annoucementRepository.findAll(PageRequest.of(page, size));

		List<Announce> result= annouceRepository.findAnnouncementsBySponsoredIsTrueOrderBySponsoringWeightDesc();
		Announce ann=result.get(0);
		SponsoringPlan sp=ann.getSponsoringPlans().get(0);
		sp.setSelectedBysponsoring(sp.getSelectedBysponsoring()+1);
		sponsoringPlanRepository.save(sp);
		//update new weight
		Double new_weight=calcule_the_sponsoring_weight(sp.getReach(),sp.getDelay(),ann.getRating(),sp.getViewsBysponsoring(),sp.getSelectedBysponsoring());
		ann.setSponsoringWeight(new_weight);
		annouceRepository.save(ann);


		return result.get(0).getIdAnnouncement();

	}

	public Double calcule_the_sponsoring_weight(Long reach,Long delay, Float rating,  Long viewsBysponsoring,Long selectedBysponsoring ){

		Float viewsToSelectedPercentage= Float.valueOf(selectedBysponsoring/viewsBysponsoring);

		Double weight = Double.valueOf(reach*0.2 + (viewsBysponsoring/delay)*0.71 + rating*1 +viewsToSelectedPercentage*5);

		return weight;

	}

	public String openAnnouncementThrowSponsoring(Long id) {
		Announce ann= annouceRepository.findById(id).get();

		if(ann.getSponsored())
		{
			SponsoringPlan sp=ann.getSponsoringPlans().get(0);
			sp.setViewsBysponsoring(sp.getViewsBysponsoring()+1);

			Double new_weight=calcule_the_sponsoring_weight(sp.getReach(),sp.getDelay(),ann.getRating(),sp.getViewsBysponsoring(),sp.getSelectedBysponsoring());


			ann.setSponsoringWeight(new_weight);
			annouceRepository.save(ann);
			sponsoringPlanRepository.save(sp);

			return "done";
		}
		return "not sponsored announcement";


	}





}
package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.immoprojectmicroservice.entities.Announce;
import com.example.immoprojectmicroservice.service.*;

///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "Statsticts  controller  (bsd)")
@RequestMapping( "api/public")
public class StatisticsController {

	@Autowired
	StatisticsABService statisticsABService;
	@ApiOperation(value = "pourcentage du type des utilisateurs")
	@GetMapping("/staticts/users")
	@ResponseBody
	public ResponseEntity<Announce> retrieve_pourcentage_accounts() {

		return new ResponseEntity(statisticsABService.pourcentage_type_users(), HttpStatus.OK);


	}

	@ApiOperation(value = "statistique sur le status des reclamations")
	@GetMapping("/staticts/reclamations")
	@ResponseBody
	public ResponseEntity<Announce> retrieve_pourcentage_reclamations() {

		return new ResponseEntity(statisticsABService.pourcentage_reclamation(), HttpStatus.OK);


	}

	@ApiOperation(value = "statistique sur l'avanvement des plans de sponsoring pour les annonces")
	@GetMapping("/staticts/sponsoring")
	@ResponseBody
	public ResponseEntity<Announce> retrieve_pourcentage_sponsoring() {

		return new ResponseEntity(statisticsABService.pourcentage_sponsoring_objectifs(), HttpStatus.OK);


	}




}

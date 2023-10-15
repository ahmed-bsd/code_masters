package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.immoprojectmicroservice.entities.Reclamation;
import com.example.immoprojectmicroservice.service.ReclamationService;

import java.security.Principal;
import java.util.List;



///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "Reclamation APIs")
@RequestMapping( "api/user/")
public class ReclamationController {

	@Autowired
	ReclamationService reclamationService;

	@ApiOperation(value = "Retrieve all reclamations")
	@GetMapping("reclamation/retrieve")
	@ResponseBody
	public List<Reclamation> retrieveRec() {
		return reclamationService.retrieveAllReclamations() ;
	}

	@ApiOperation(value = "add Reclamation")
	@PostMapping("reclamation/add")
	@ResponseBody
	public ResponseEntity<String> SaveReclamation(@RequestBody Reclamation reclamation,Principal principal) {

      	return 	reclamationService.addReclamation(reclamation,principal);


	}

	@ApiOperation(value = "delete reclamation")
	@DeleteMapping ("/reclamation/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleterec(@PathVariable Long  id,Principal principal) {

		return  reclamationService.deleteReclamation(id,principal);


	}


	@ApiOperation(value = "delete a reclamation")
	@PutMapping ("/reclamation/edit/{id}")
	@ResponseBody
	public ResponseEntity<String> editrec(@RequestBody Reclamation rec) {

		reclamationService.update(rec);
		return  new ResponseEntity<>("updated" , HttpStatus.OK);


	}






}

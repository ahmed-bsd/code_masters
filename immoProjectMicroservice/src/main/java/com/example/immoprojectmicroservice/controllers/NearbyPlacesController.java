package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.immoprojectmicroservice.service.NearbyPlacesService;

///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "nearby places")
@RequestMapping( "api/public/")
public class NearbyPlacesController {

     @Autowired
	NearbyPlacesService nearbyPlacesService;

    //http://localhost:8081/SpringMVC/swagger-ui/index.html

	@ApiOperation(value = "Nearby places")
	@GetMapping("nearby")
	@ResponseBody
	public void nearby(@RequestParam Float alt,@RequestParam Float lg,@RequestParam String type) {


		 nearbyPlacesService.nearby(alt,lg,type);

	}






}

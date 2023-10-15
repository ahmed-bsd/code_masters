package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "Sellers")
@RequestMapping( "api/user/seller/")
public class SellerController {



	@ApiOperation(value = "Retrieve all announces")
	@GetMapping("announces")
	@ResponseBody
	public String RetrieveAllannounces() {

		return "List of announcements ..";

	}






}

package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.immoprojectmicroservice.service.AdminService;
import com.example.immoprojectmicroservice.service.UserService;

///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "Admin Dashboard")
@RequestMapping( "api/dashboard/")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;
    //http://localhost:8081/SpringMVC/swagger-ui/index.html

	@ApiOperation(value = "Retrieve all sellers")
	@GetMapping("sellers")
	@ResponseBody
	public String RetrieveAllSellers() {

		return "List of sellers ..";

	}

	@ApiOperation(value = "ban a user")
	@PostMapping("users/ban/{username}/{duration}")
	@ResponseBody
	public ResponseEntity<String> RetrieveAllSellers( @PathVariable String username,@PathVariable Long duration) {

		return userService.banUser(username,duration);

	}






}

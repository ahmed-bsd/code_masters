package com.example.immoprojectmicroservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.immoprojectmicroservice.entities.UserA;
import com.example.immoprojectmicroservice.repository.UserRepository;
import com.example.immoprojectmicroservice.serviceInterface.IAdminService;

import java.util.List;

///****    Developped by Ahmed bsd    ****////
@Service
@Slf4j
public class AdminService implements IAdminService {

	@Autowired
	UserRepository userRepository;


	@Override
	public List<UserA> retrieveAllSellers() {
		return userRepository.findAllByRoleIs("ADMIN").get();
	}





}
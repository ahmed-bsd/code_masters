package com.example.immoprojectmicroservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.immoprojectmicroservice.entities.TokenConfirmation;
import com.example.immoprojectmicroservice.repository.TokenConfirmRepository;

import java.util.Optional;


///****    Developped by Ahmed bsd    ****////
@Service
@Slf4j
public class TokenConfirmService {

	@Autowired
	TokenConfirmRepository tokenConfirmRepository;

	public void saveConfirmationToken(TokenConfirmation token) {
		tokenConfirmRepository.save(token);
	}


	public void disableToken(String token) {
		TokenConfirmation tokenConfirmation=tokenConfirmRepository.findByToken(token).get();
		if (!tokenConfirmation.getExpired()){
			tokenConfirmation.setExpired(true);
			tokenConfirmRepository.save(tokenConfirmation);
		}
	}
	public Optional<TokenConfirmation> getToken(String token) {
		return tokenConfirmRepository.findByToken(token);
	}



}
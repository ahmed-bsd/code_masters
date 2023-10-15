package com.example.immoprojectmicroservice.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Slf4j
public class LoggingAspect {

	@Before("execution(public * com.example.immoprojectmicroservice.service.*.* (..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		log.info("In method : " + joinPoint.getSignature().getName() + " : ");
	}

	@AfterReturning("execution(* com.example.immoprojectmicroservice.service.*.*(..))")
	public void logMethodExit1(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("Out of method without errors : " + name );
	}

	@AfterThrowing("execution(* com.example.immoprojectmicroservice.service.*.*(..))")
	public void logMethodExit2(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.error("Out of method with erros : " + name );
	}

	@After("execution(* com.example.immoprojectmicroservice.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("Out of method : " + name );
	}
}
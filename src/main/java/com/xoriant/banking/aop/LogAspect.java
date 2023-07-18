package com.xoriant.banking.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.context.annotation.EnableAspectJAutoProxy;


//import org.aspectj.lang.annotation.Aspect;
import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Slf4j
@Aspect

public class LogAspect {
	
     
	     @Around("execution(public int com.xoriant.banking.DTO.UserDTO.getUserName())")
		 public Object logAroundUserName(ProceedingJoinPoint proceedingJoinPoint) {
		     log.info("The Around Advice Before Log is created by Aspect");
           
			Object obj = null;
			try {
				obj = proceedingJoinPoint.proceed();
			} catch (Throwable e) {

			}

			log.info("The Around Advice After Log is created by Aspect with value :" + obj);

			return obj;
		}
	     
	     
	
	
}
package com.biz.common;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAspect {

	@Before("pointCut()")
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName=joinPoint.getSignature().getName();
		Signature Signature=joinPoint.getSignature();
		try {
			CreateLogFile.log(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("beforeMethod run....methodName::"+methodName);
		System.out.println("beforeMethod run....Signature::"+Signature);
	}
	
	@After("pointCut()")
	public void afterMethod() {
		System.out.println("afterMethod run....");
	}
	
	@Pointcut("execution(public * com.biz..*ServiceImpl.*(..))")
	public void pointCut() {}
	
	
	public void errorMethod(JoinPoint joinPoint) {
		
		String methodName=joinPoint.getSignature().getName();
		Signature Signature=joinPoint.getSignature();
		try {
			CreateLogFile.log(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

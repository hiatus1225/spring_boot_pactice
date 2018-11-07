package com.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//what  	when 	where
//Aspect  	advice 	pointcut
@Component
@Aspect
public class CommonAspect {
	
	@Pointcut("execution( public * com.biz..*Impl.*(..) )")
	public void dummy() {}
	
//	@Pointcut("execution( public * com.biz..User*Impl.*(..) )")
//	public void udummy() {}
	
	//@Before("dummy() || udummy()")
	@Before("dummy()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("beforeMethod()....." + jp.getSignature());
	}
	
	@After("dummy()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("afterMethod()....." + jp.getSignature());
	}
}

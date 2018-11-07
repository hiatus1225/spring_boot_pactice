package com.biz.common;

import java.io.IOException;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void logging(ProceedingJoinPoint joinPoint) {
		String signal=joinPoint.getSignature().getName();
		try {
			CreateLogFile.log(signal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

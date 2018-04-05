package com.smartpay.example;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MonitorAspect {
	// com.dragon.study.springboot.example.api.
	@Around("within(* com.dragon.study.springboot.example.api.*.*(..))")
	public void test() {
		System.out.println("monitor ...... ");
	}
}

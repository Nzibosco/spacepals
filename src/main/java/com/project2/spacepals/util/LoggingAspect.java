package com.project2.spacepals.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
private final Logger LOG = LogManager.getLogger(this.getClass());

@Pointcut("within(com.project2..*)")
public void logAll(){}

public void logMethodStart(JoinPoint jp){
    System.out.println("Please help me ALLAH");
    String methodSig = jp.getTarget().getClass().toString()+"."+jp.getSignature().getName();
    LOG.info("{} invoked at {}",methodSig, LocalTime.now());
    LOG.info("Input arguments: {}", Arrays.toString(jp.getArgs()));
}
}

package com.example.jenkinsdemo.config.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: lichaoyang
 * @Date: 2019-09-09 20:35
 */
public abstract class AbastractAspect {
    public AbastractAspect() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)||  @annotation(org.springframework.web.bind.annotation.GetMapping)||  @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void pointcut() {
    }
}
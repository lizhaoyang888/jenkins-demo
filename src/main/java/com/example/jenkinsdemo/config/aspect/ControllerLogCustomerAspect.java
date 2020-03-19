package com.example.jenkinsdemo.config.aspect;


import com.example.jenkinsdemo.util.JsonUtil;
import com.example.jenkinsdemo.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求日志切面
 *
 * @author lichaoyang
 */
@Order(1)
@Aspect
@Slf4j
@Component
public class ControllerLogCustomerAspect {
	public static final String REQUEST_ID = "request_id";

	private ThreadLocal<Long> startTime = new ThreadLocal<>();

	/**
	 * Controller切点
	 */
	@Pointcut(
			"@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
					"@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
					"@annotation(org.springframework.web.bind.annotation.PostMapping) "
	)
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		MDC.put(REQUEST_ID, UUIDUtil.generateUniqueIdWithUUID());

		ServletRequestAttributes attributes =
				(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {
			startTime.set(System.currentTimeMillis());
			HttpServletRequest request = attributes.getRequest();
			log.info("REQUEST URL==>{}, args==>{}", request.getRequestURL(), joinPoint.getArgs());
		}
	}

	@AfterReturning(value = "pointcut()", returning = "result")
	public void after(Object result) {
		ServletRequestAttributes attributes =
				(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {
			HttpServletRequest request = attributes.getRequest();
			log.info("RESPONSE URL==>{}, cost==>{}ms, result==>{}", request.getRequestURL(), System.currentTimeMillis() - startTime.get(), JsonUtil.object2Json(result));
		}
		MDC.remove(REQUEST_ID);
		startTime.remove();
	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
	public void afterThrowing(Exception e) {
		startTime.remove();
	}
}

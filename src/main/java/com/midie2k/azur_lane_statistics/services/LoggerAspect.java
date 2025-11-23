package com.midie2k.azur_lane_statistics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Around("execution(* com.midie2k.azur_lane_statistics..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String formattedArgs = formatArguments(args);

        log.debug("Enter: {}() with arguments = {}", method, formattedArgs);

        Object result = joinPoint.proceed();

        String formattedResult = formatResult(result);

        log.debug("Exit: {}() returning = {}", method, formattedResult);

        return result;
    }


    private String formatArguments(Object[] args) {
        return Arrays.stream(args)
                .map(this::formatValue)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String formatResult(Object result) {
        if (result instanceof ResponseEntity<?> resp) {
            Object body = resp.getBody();
            if (body instanceof Page<?> page) {
                return safeJson(page.getContent());
            }
            return safeJson(body);
        }

        if (result instanceof Page<?> page) {
            return safeJson(page.getContent());
        }

        return safeJson(result);
    }

    private String formatValue(Object value) {

        if (value == null) return "null";

        if (value instanceof Pageable pageable) {
            return "Pageable(page=" + pageable.getPageNumber() +
                    ", size=" + pageable.getPageSize() +
                    ", sort=" + pageable.getSort() + ")";
        }

        if (value instanceof Page<?> page) {
            return "Page(content=" + safeJson(page.getContent()) +
                    ", total=" + page.getTotalElements() + ")";
        }

        if (isSimple(value)) {
            return value.toString();
        }

        return safeJson(value);
    }

    private String safeJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return obj.toString(); // fallback
        }
    }

    private boolean isSimple(Object obj) {
        return obj instanceof String ||
                obj instanceof Number ||
                obj instanceof Enum ||
                obj instanceof Boolean;
    }
}
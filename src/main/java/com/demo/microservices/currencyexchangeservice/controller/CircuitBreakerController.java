package com.demo.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "sample-api")
    @GetMapping("sample")
    public String sampleAPI(){

        logger.info("Sample API call to test");
//
//        ResponseEntity<String> forEnity = new RestTemplate().getForEntity("http://localhost:8080/api/sample",
//                String.class);

//        return forEnity.getBody();
        return "Sample-API";
    }

    public String hardCodedResponse(Exception exception){
        return "Hardcoded fall back response";
    }
}

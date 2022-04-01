package com.dailcodebuffer.cloud.gateway;


import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    private static final String traceId = "tracedId";
    @Retry(name = traceId)
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is down" +
                "Please try again later";
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is down" +
                "Please try again later";
    }

}

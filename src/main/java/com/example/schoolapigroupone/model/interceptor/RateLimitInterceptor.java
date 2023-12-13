package com.example.schoolapigroupone.model.interceptor;

import com.example.schoolapigroupone.model.exception.ServiceUnavailableException;
import com.example.schoolapigroupone.model.exception.TooManyRequestException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private static final int TOO_MANY_REQUESTS_MAX_REQUESTS = 3;
    private static final int UNAVAILABLE_SERVICE_MAX_REQUESTS = 6;
    private int requestCount = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (requestCount == TOO_MANY_REQUESTS_MAX_REQUESTS) {
            throw new TooManyRequestException();
        } else if(requestCount >= UNAVAILABLE_SERVICE_MAX_REQUESTS){
            throw new ServiceUnavailableException();
        }else {
            requestCount++;
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        requestCount = 0;
    }
}

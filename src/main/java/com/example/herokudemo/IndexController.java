package com.example.herokudemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
    
    @GetMapping("/test")
        public String error(HttpServletRequest request) {
            return getClientIp(request);
        }
    
    private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}

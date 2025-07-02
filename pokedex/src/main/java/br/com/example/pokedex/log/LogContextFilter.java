package br.com.example.pokedex.log;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            HttpServletRequest req = (HttpServletRequest) request;
            String ip = req.getHeader("X-Forwarded-For");
            if (ip == null || ip.isEmpty()) {
                ip = req.getRemoteAddr();
            }

            String userAgent = req.getHeader("User-Agent");

            // Put data into Log4j2 ThreadContext (MDC)
            ThreadContext.put("ip", ip);
            ThreadContext.put("userAgent", userAgent);

            chain.doFilter(request, response);
        } finally {
            ThreadContext.clearMap();
        }
    }
}

package br.com.b2vnauthapi.b2vnauthapi.config.auth;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomTokenEndpointAuthenticationFilter extends GenericFilterBean implements Filter {

    private static final String URL_OAUTH_TOKEN = "/oauth/token";
    private static final String CONTENT_TYPE_TOKEN_REQUEST = "multipart/form-data";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if (isValidTokenRequest(servletRequest)) {
            sendErrorValidation(servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isValidTokenRequest(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        return !(servletRequest instanceof SecurityContextHolderAwareRequestWrapper)
                && request.getRequestURI().contains(URL_OAUTH_TOKEN)
                && request.getContentType().contains(CONTENT_TYPE_TOKEN_REQUEST);
    }

    private void sendErrorValidation(ServletResponse servletResponse) throws IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Authorization, Origin, X-Requested-With, Content-Type, Accept");
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Acesso negado.");
    }
}

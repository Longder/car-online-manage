package com.longder.car.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功后的处理
 */
public class FormLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    Logger logger = LoggerFactory.getLogger(FormLoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.debug("登陆成功！");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}

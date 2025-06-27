package com.fatec.cadastro_produto.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        boolean logado = (session != null && session.getAttribute("usuarioLogado") != null);

        if (!logado) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}

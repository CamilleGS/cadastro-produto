package com.fatec.cadastro_produto.controller;

import com.fatec.cadastro_produto.business.UsuarioService;
import com.fatec.cadastro_produto.infrastructure.entitys.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UsuarioUIController {

    private final UsuarioService usuarioService;

    @GetMapping("/login")
    public String telaLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        var autenticado = usuarioService.autenticar(usuario.getLogin(), usuario.getSenha());
        if (autenticado.isPresent()) {
            session.setAttribute("usuarioLogado", autenticado.get());
            return "redirect:/ui/produtos";
        } else {
            model.addAttribute("erro", "Login ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

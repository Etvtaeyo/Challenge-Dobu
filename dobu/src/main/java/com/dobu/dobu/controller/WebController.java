package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Agendamento;
import com.dobu.dobu.entity.Usuario;
import com.dobu.dobu.repository.AgendamentoRepository;
import com.dobu.dobu.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public WebController(AgendamentoRepository agendamentoRepository, UsuarioRepository usuarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("agendamentos", agendamentoRepository.findAll());
        model.addAttribute("usuario", usuarioRepository.findByEmail(authentication.getName()).map(Usuario::getNome).orElse(authentication.getName()));
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}


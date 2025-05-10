package com.acm.mvc.controllers;

import com.acm.mvc.models.Usuario;
import com.acm.mvc.services.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @GetMapping("/login")
    public String index(Model model){
        model.addAttribute("usuario",new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model){
        if (result.hasErrors()){
            return "login";
        }
        Optional<Usuario> user  = usuarioService.findByUsername(usuario.getUsername());
        if (user.isEmpty()){
            model.addAttribute("error", "Usuario no encontrado");
            return "login";
        }
        if (!user.get().getPassword().equals(usuario.getPassword())){
            model.addAttribute("error", "Acceso denegado");
            return "login";
        }
        List<Usuario> users = usuarioService.findAll();
        for (Usuario u : users){
            log.info("User: {}",u);
        }
        model.addAttribute("username",usuario.getUsername());
        model.addAttribute("usuarios",users);
        return "dashboard";
    }


}

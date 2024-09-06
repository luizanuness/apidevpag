package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping ("/usuario")
@Controller
public class UsuarioController {

    //direcionar para login/user.html
    @GetMapping ("/perfil")
    public String perfil(){
        return "user/user";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cad/cadAdm";
    }
}
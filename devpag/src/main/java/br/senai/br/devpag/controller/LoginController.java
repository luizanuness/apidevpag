package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping ("/usuario")
@Controller
public class UsuarioController {

    @GetMapping ("/login")
    public String perfil(){
        return "login/login";
    }

    @GetMapping("/cadAdm")
    public String cadAdm(){
        return "cad/cadAdm";
    }
}
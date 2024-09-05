package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    //direcionar para login/user.html
    @GetMapping("/usuario")
    public String user(){
        return "login/user";
    }

}
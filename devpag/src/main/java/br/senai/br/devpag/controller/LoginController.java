package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //login
    @GetMapping("/login")
    public String login(){
        return "/inicio/login";
    }

    @GetMapping("/error")
    public String loginError(){
        return ".../login-error";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler(){
        return "/";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler(){
        return "login";
    }

    @PostMapping("/error")
    public String error(){
        return "/.../login-error";
    }




    //cadastro

    @GetMapping("/cad/administrador")
    public String cadADM(){
        return "/cad/cadAdm";
    }

    @GetMapping("/cad/responsavel")
    public String cadRESP(){
        return "/cad/cadResp";
    }
}
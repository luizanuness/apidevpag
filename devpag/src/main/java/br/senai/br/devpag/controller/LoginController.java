package br.senai.br.devpag.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    //login
    @GetMapping("/login")
    public String login(){
        return "/inicio/login";
    }


        //sucesso no login
        @PostMapping("/login_success_handler")
        public String loginSuccessHandler(){
            //obtem usuario
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()){
                return "redirect:/login";
            }

            //obtem detalhes
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(auth -> auth.getAuthority())
                    .orElse("ROLE_USER");
            //redireciona de acordo com tipo de pessoa
            switch (role){
                case "ROLE_ADMINISTRADOR":
                    return "redirect:/home/adm";
                case "ROLE_RESPONSAVEL":
                    return "redirect:/home/resp";
                case "ROLE_PORTARIA":
                    return "redirect:/home/port";
                default:
                    return "redirect:/home/default";
            }
        }

   //falha de login
    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        return "redirect:/login?error=true";
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
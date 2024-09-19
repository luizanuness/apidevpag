package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    //login
    @GetMapping("/login")
    public String login(){
        return "/inicio/login";
    }


        //sucesso no login
        @PostMapping("/login_success_handler")
        public String loginSuccessHandler(){
            //obtem usuario autenticado
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()){
                return "redirect:/login";
            }

            //obtem detalhes do usuario
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            Pessoa pessoa = (Pessoa) userDetailsService.loadUserByUsername(username);

            //verifica tipo de pessoa
            String tipoPessoa = pessoa.getTipoPessoa();
            switch (tipoPessoa){
                case "D":
                    return "redirect:/administrador/Home";
                case "R":
                    return "redirect:/responsavel/homeResp";
                case "P":
                    return "redirect:/portaria/home";
                default:
                    return "redirect:/home/default";
            }
        }

}
package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/navegacao")
public class NavegacaoController {

    @GetMapping ("/ajuda")
    public String ajuda(){
        return "navegacao/ajuda";
    }

    @GetMapping("/contato")
    public String contato(){
        return "navegacao/contato";
    }

}

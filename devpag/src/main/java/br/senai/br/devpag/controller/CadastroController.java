package br.senai.br.devpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {

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

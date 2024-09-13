package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Administrador;
import br.senai.br.devpag.model.Portaria;
import br.senai.br.devpag.repository.AdministradorRepository;
import br.senai.br.devpag.repository.PortariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/portaria")
public class PortariaController {

    @Autowired
    private PortariaRepository portariaRepository;


    //lista de funcionarios da portaria
    @GetMapping
    public String listagem(Model model){

        List<Portaria> listaFuncionarios = portariaRepository.findAll();

        model.addAttribute("funcionarios", listaFuncionarios);

        return "portaria/listagem";
    }
}

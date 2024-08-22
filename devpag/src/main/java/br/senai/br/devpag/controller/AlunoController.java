package br.senai.br.devpag.controller;

import br.senai.br.devpag.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    // direcionar para listagem de alunos
    @GetMapping
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "cadastros/aluno/listagem";
    }

}
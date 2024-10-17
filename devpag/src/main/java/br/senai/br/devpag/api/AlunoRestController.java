package br.senai.br.devpag.api;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoRestController {

    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }


    // Método para inserir alunos via protocolor rest por post
    @PostMapping("/api/inserir")
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }


}

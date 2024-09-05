package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    // direcionar para listagem de alunos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listagem";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "cad/cadAluno";
    }

    @PostMapping("/inserir")
    public String inserir(
            @Valid Aluno aluno,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "aluno/cadAluno";
        }
        alunoRepository.save(aluno);
        redirectAttributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        return "redirect:/aluno/form-inserir";
    }
}


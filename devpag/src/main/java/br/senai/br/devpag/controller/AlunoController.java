package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.model.Responsavel;
import br.senai.br.devpag.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // direcionar para listagem de alunos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listagem";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/form-inserir";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid Aluno aluno,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "aluno/form-inserir";
        }


        if(!aluno.getUser().getPassword().isEmpty()){
            aluno.getUser().setFirstName(aluno.getNome());
            aluno.getUser().setEmail(aluno.getEmail());
            aluno.getUser().setUsername(aluno.getEmail());
            aluno.getUser().setPassword(bCryptPasswordEncoder.encode(aluno.getUser().getPassword()));

        }

        // Percorre os responsáveis do aluno e carrega o usuário do responsável
        for (Responsavel responsavel : aluno.getResponsaveis()) {
            if(!responsavel.getUser().getPassword().isEmpty()){
                responsavel.getUser().setFirstName(responsavel.getNome());
                responsavel.getUser().setEmail(responsavel.getEmail());
                responsavel.getUser().setUsername(responsavel.getEmail());
                responsavel.getUser().setPassword(bCryptPasswordEncoder.encode(responsavel.getUser().getPassword()));
            }
        }



        alunoRepository.save(aluno);
        redirectAttributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        return "redirect:/aluno";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(@PathVariable Long id, Model model) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));

        model.addAttribute("aluno", aluno);


        return "aluno/form-alterar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        alunoRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("mensagem", "Aluno removido com sucesso!");

        return "redirect:/aluno";
    }

    @PostMapping("/addResponsavel")
    public String addResponsavel(Aluno aluno, Model model){
        aluno.addResponsavel(new Responsavel());
        return "aluno/form-inserir :: responsaveis";
    }

    @PostMapping("/removeResponsavel")
    public String removeResponsavel(Aluno aluno, Model model, @RequestParam("removeDynamicRow") Integer responsavelIndex){
        aluno.getResponsaveis().remove(responsavelIndex.intValue());
        return "aluno/form-inserir :: responsaveis";
    }

}
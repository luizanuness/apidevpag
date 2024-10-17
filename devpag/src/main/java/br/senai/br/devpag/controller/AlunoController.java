package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
            return "aluno/listagem";
        }


        if(!aluno.getUser().getPassword().isEmpty()){
            aluno.getUser().setFirstName(aluno.getNome());
            aluno.getUser().setEmail(aluno.getEmail());
            aluno.getUser().setUsername(aluno.getEmail());
            aluno.getUser().setPassword(bCryptPasswordEncoder.encode(aluno.getUser().getPassword()));

        }


        alunoRepository.save(aluno);
        redirectAttributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        return "redirect:/aluno";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoRepository.findById(id));
        return "aluno/form-alterar";
    }

    @GetMapping("/excluir/{id}")
    public String exluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        alunoRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("mensagem", "Aluno removido com sucesso!");

        return "redirect:/aluno";
    }

}
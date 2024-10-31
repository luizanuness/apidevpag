package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.model.Funcionario;
import br.senai.br.devpag.model.Responsavel;
import br.senai.br.devpag.repository.AlunoRepository;
import br.senai.br.devpag.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // direcionar para listagem de alunos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", funcionarioRepository.findAll());
        return "funcionario/listagem";
    }

    @GetMapping("/form-inserir")
    public String formInserir(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/form-inserir";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid Funcionario funcionario,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "funcionario/listagem";
        }


        if(!funcionario.getUser().getPassword().isEmpty()){
            funcionario.getUser().setFirstName(funcionario.getNome());
            funcionario.getUser().setEmail(funcionario.getEmail());
            funcionario.getUser().setUsername(funcionario.getEmail());
            funcionario.getUser().setPassword(bCryptPasswordEncoder.encode(funcionario.getUser().getPassword()));

        }





        funcionarioRepository.save(funcionario);
        redirectAttributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso!");
        return "redirect:/funcionario";
    }

    @GetMapping("/form-alterar/{id}")
    public String formAlterar(@PathVariable Long id, Model model) {

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));

        model.addAttribute("funcionario", funcionario);


        return "funcionario/form-alterar";
    }

    @GetMapping("/excluir/{id}")
    public String exluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        funcionarioRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("mensagem", "Funcionario removido com sucesso!");

        return "redirect:/funcionario";
    }



}
package br.senai.br.devpag.controller;


import br.senai.br.devpag.model.Administrador;
import br.senai.br.devpag.model.Responsavel;
import br.senai.br.devpag.repository.ResponsavelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/responsavel")
public class ResponsavelController {

    //conectando paginas
    @GetMapping("/resp")
    public String responsavel(){
        return "/responsavel/homeResp";
    }

    @Autowired
    private ResponsavelRepository responsavelRepository;

    //direciona para listagem
    @GetMapping
    public String listagem(Model model){
        List<Responsavel> listaResponsaveis = responsavelRepository.findAll();

        model.addAttribute("responsaveis", listaResponsaveis);

        return "responsavel/listagem";
    }

    //cadastrar responsavel

    @GetMapping("/novo")
    public String cadastrar(Model model){
        model.addAttribute("responsavel", new Responsavel());

        return "responsavel/form-inserir";
    }

    @PostMapping("/salvar")
    public String salvarResponsavel(@Valid Responsavel responsavel,
                                    BindingResult result,
                                    RedirectAttributes attributes){
        if (result.hasErrors()){
            return "responsavel/form-inserir";
        }
        if (errosPersonalizadosInsercao(responsavel, result).hasErrors()){
            return "responsavel/form-inserir";
        }

        //salva responsavel no banco
        responsavelRepository.save(responsavel);

        attributes.addFlashAttribute("mensagem", "Responsável salvo!");

        return "redirect:/responsavel/novo";
    }

    //direcionar para alterar responsavel
    @GetMapping ("/alterar/{id}")
    public String alterar(Model model, @PathVariable Long id){

        Responsavel responsavel = responsavelRepository.findById(id).get();

        model.addAttribute("responsavel", responsavel);

        return "responsavel/alterar";
    }

    //deletar responsavel
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Responsavel responsavel = responsavelRepository.findById(id).get();

        responsavelRepository.delete(responsavel);

        redirectAttributes.addFlashAttribute("mensagem", "Responsável excluído!");

        return "redirect:/responsavel";
    }

    //verifica email e cpf ja cadastrados
    public BindingResult errosPersonalizadosInsercao(Responsavel responsavel, BindingResult result){

        //verifica email já cadastrado
        if(responsavelRepository.findByEmail(responsavel.getEmail()) != null){
            result.rejectValue("email", "email.existente", "E-mail já cadastrado");
        }

        //verifica cpf já cadastrado
        if (responsavelRepository.findByCpf(responsavel.getCpf()) != null){
            result.rejectValue("cpf", "cpf.existente", "CPF já cadastrado");
        }

        return result;
    }

}

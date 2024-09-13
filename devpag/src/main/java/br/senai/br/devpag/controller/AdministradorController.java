package br.senai.br.devpag.controller;


import br.senai.br.devpag.model.Administrador;
import br.senai.br.devpag.repository.AdministradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;


    //lista de adms
    @GetMapping
    public String listagem(Model model){

        List<Administrador> listaAdministradores = administradorRepository.findAll();

        model.addAttribute("administradores", listaAdministradores);

        return "administrador/listagem";
    }

    //adicionar adm
    @GetMapping("/novo")
    public String cadastrar(Model model){
        model.addAttribute("administrador", new Administrador());
        return "administrador/form-inserir";
    }

    //salvar adm no banco
    @PostMapping("/salvar")
    public String salvar(@Valid Administrador administrador,
                         BindingResult result,
                         RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "administrador/form-inserir";
        }

        redirectAttributes.addFlashAttribute("mensagem", "Administrador cadastrado!");

        administradorRepository.save(administrador);
        return "redirect:/administrador/novo";
    }

    //direcionar para alterar adm
    @GetMapping ("/alterar/{id}")
    public String alterar(Model model, @PathVariable Long id){

        Administrador administrador = administradorRepository.findById(id).get();

        model.addAttribute("administrador", administrador);

        return "administrador/alterar";
    }

    //deletar adm
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Administrador administrador = administradorRepository.findById(id).get();

        administradorRepository.delete(administrador);

        redirectAttributes.addFlashAttribute("mensagem", "Administrador excluído!");

        return "redirect:/administrador";
    }

}


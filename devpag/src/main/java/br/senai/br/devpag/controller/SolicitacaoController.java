package br.senai.br.devpag.controller;

import br.senai.br.devpag.model.Administrador;
import br.senai.br.devpag.model.Solicitacao;
import br.senai.br.devpag.repository.AdministradorRepository;
import br.senai.br.devpag.repository.SolicitacaoRepository;
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

@RequestMapping("/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;


    //lista de solicitacao
    @GetMapping
    public String listagem(Model model){

        List<Solicitacao> listaSolicitacoes = solicitacaoRepository.findAll();

        model.addAttribute("solicitacoes", listaSolicitacoes);

        return "solicitacao/listagem";
    }

    //adicionar solicitacao
    @GetMapping("/novo")
    public String adicionar(Model model){
        model.addAttribute("solicitacao", new Solicitacao());
        return "solicitacao/form-inserir";
    }

    //salvar a nova solicitacao no banco
    @PostMapping("/salvar")
    public String salvar(@Valid Solicitacao solicitacao,
                         BindingResult result,
                         RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "solicitacao/form-inserir";
        }

        redirectAttributes.addFlashAttribute("mensagem", "Solicitação enviada! Aguarde confirmação.");

        solicitacaoRepository.save(solicitacao);
        return "redirect:/solicitacao/novo";
    }

    //direcionar para editar a solicitacao
    @GetMapping ("/alterar/{id}")
    public String alterar(Model model, @PathVariable Long id){

        Solicitacao solicitacao = solicitacaoRepository.findById(id).get();

        model.addAttribute("solicitacao", solicitacao);

        return "solicitacao/alterar";
    }

    //deletar solicitacao
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Solicitacao solicitacao = solicitacaoRepository.findById(id).get();

        solicitacaoRepository.delete(solicitacao);

        redirectAttributes.addFlashAttribute("mensagem", "Solicitação excluída!");

        return "redirect:/solicitacao";
    }
}

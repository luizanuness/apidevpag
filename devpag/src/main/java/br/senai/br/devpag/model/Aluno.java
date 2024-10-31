package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//determina que A = Aluno no tipo de pessoa
@DiscriminatorValue(value = "A")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa {
    private Long matricula;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "alunos_responsaveis",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "responsavel_id")
    )
    private List<Responsavel> responsaveis = new ArrayList<>();

    // método para adicionar um responsável na lista de responsáveis
    public void addResponsavel(Responsavel responsavel) {
        this.responsaveis.add(responsavel);
    }

    // método para remover um responsável da lista de responsáveis
    public void removeResponsavel(Responsavel responsavel) {
        this.responsaveis.remove(responsavel);
    }
}


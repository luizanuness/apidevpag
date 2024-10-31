package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//determina que R = Responsavel no tipo de pessoa
@DiscriminatorValue(value = "R")

public class Responsavel extends Pessoa{

    @ManyToMany(mappedBy = "responsaveis")
    private List<Aluno> alunos = new ArrayList<>();

}

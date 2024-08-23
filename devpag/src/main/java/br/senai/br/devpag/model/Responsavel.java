package br.senai.br.devpag.model;

import jakarta.persistence.*;

@Entity

//determina que R = Responsavel no tipo de pessoa
@DiscriminatorValue(value = "R")

public class Responsavel extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

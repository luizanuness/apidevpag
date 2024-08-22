package br.senai.br.devpag.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity

//determina que R = Responsavel no tipo de pessoa
@DiscriminatorValue(value = "R")

public class Responsavel extends Pessoa{


}

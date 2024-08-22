package br.senai.br.devpag.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity

//determina que D = Direcao no tipo de pessoa
@DiscriminatorValue(value = "D")

public class Direcao {
}

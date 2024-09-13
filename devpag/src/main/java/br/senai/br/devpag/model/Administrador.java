package br.senai.br.devpag.model;

import jakarta.persistence.*;

@Entity
//determina que D = Direcao no tipo de pessoa
@DiscriminatorValue(value = "D")

public class Administrador extends Pessoa {
}

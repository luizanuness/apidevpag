package br.senai.br.devpag.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
//determina que R = Responsavel no tipo de pessoa
@DiscriminatorValue(value = "F")

public class Funcionario extends Pessoa{

}

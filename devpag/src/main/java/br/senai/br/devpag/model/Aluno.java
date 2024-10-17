package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
//determina que A = Aluno no tipo de pessoa
@DiscriminatorValue(value = "A")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa{
   private Long matricula;
}


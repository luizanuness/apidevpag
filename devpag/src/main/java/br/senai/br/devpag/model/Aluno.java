package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity

//determina que A = Aluno no tipo de pessoa
@DiscriminatorValue(value = "A")
public class Aluno extends Pessoa{

   private Long matricula;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
}


package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos_responsavel")
public class AlunosReponsaveis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long aluno_id;
    private Long responsavel_id;
}

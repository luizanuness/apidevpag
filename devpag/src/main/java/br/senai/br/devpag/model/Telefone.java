package br.senai.br.devpag.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    private String DDI;
    private Integer DDD;
    private String tipo;
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
}
package br.senai.br.devpag.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Setter
@Getter
//tipos de pessoa

@DiscriminatorColumn(
        name = "tipoPessoa",
        length = 1,
        discriminatorType = DiscriminatorType.STRING
)
public class Pessoa {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    //cpf
    @NotEmpty(message = "CPF deve ser informado")
    @CPF(message = "CPF inválido")
    private String cpf;

    //nome
    @NotEmpty(message = "Nome deve ser informado")
    private String nome;

    //email
    @NotEmpty(message = "E-mail deve ser informado")
    @Email(message = "E-mail inválido")
    private String email;

    //senha
    @NotEmpty(message = "Senha deve ser informada")
    private String senha;

    //data de nascimento
    @NotEmpty(message = "Data de nascimento deve ser informada")
    private Date dataNascimento;


}

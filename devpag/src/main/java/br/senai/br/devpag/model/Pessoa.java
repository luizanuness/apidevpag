package br.senai.br.devpag.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


@Data
@AllArgsConstructor
@NoArgsConstructor
//tipos de pessoa
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipoPessoa",
        length = 1,
        discriminatorType = DiscriminatorType.STRING
)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //email
    @NotEmpty(message = "Telefone deve ser informado")
    private String telefone;

    //senha
    //@NotEmpty(message = "Senha deve ser informada")
    private String senha;



}
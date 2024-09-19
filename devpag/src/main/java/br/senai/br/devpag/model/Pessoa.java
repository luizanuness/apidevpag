package br.senai.br.devpag.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity

//id
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipoPessoa",
        length = 1,
        discriminatorType = DiscriminatorType.STRING
)



public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
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


    //telefone
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Telefone> telefones = new ArrayList<>();

    //adiciona telefone
    private void addTelefone(Telefone telefone)
    {this.telefones.add(telefone);
        telefone.setPessoa(this);
    }

    //remove telefone
    private void removeTelefone(Telefone telefone)
    {this.telefones.remove(telefone);
        telefone.setPessoa(null);
    }


    //senha
    private String senha;

}



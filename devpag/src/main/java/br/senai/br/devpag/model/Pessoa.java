package br.senai.br.devpag.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
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



public class Pessoa implements UserDetails{

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
    private String password;

    //usuario
    private String username;

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(() -> "ROLE_" + getTipoPessoa());
    }

    public String getTipoPessoa(){
        return "";
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

}



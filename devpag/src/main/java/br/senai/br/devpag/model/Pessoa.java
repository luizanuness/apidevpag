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
public class Pessoa implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    // CPF
    @NotEmpty(message = "CPF deve ser informado")
    @CPF(message = "CPF inválido")
    private String cpf;

    // Nome
    @NotEmpty(message = "Nome deve ser informado")
    private String nome;

    // Email
    @NotEmpty(message = "E-mail deve ser informado")
    @Email(message = "E-mail inválido")
    private String email;

    // Telefone
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Telefone> telefones = new ArrayList<>();

    // Senha
    private String password;
    private String username;
    private String foto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + getTipoPessoa());
    }

    public String getTipoPessoa() {
        // Retorna o tipo baseado na discriminação
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    private void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
        telefone.setPessoa(this);
    }

    private void removeTelefone(Telefone telefone) {
        this.telefones.remove(telefone);
        telefone.setPessoa(null);
    }
}

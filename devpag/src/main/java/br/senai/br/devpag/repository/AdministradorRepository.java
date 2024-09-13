package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    List<Administrador> findByNomeContainingIgnoreCase(String nome);

    Administrador findByEmail(String email);

    Administrador findByCpf(String cpf);

    //pesquisa email e id diferente do alterado
    Administrador findByEmailAndIdNot(String email, Long id);

    //pesquisa cpf e id diferente do alterado
    Administrador findByCpfAndIdNot(String cpf, Long id);

}

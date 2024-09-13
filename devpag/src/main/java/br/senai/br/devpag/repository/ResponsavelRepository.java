package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    List<Responsavel> findByNomeContainingIgnoreCase(String nome);

    Responsavel findByEmail(String email);

    Responsavel findByCpf(String cpf);

    Optional<Responsavel> findByEmailOrCpf(String email, String cpf);


    //pesquisa email e id diferente do alterado
    Responsavel findByEmailAndIdNot(String email, Long id);

    //pesquisa cpf e id diferente do alterado
    Responsavel findByCpfAndIdNot(String cpf, Long id);

}

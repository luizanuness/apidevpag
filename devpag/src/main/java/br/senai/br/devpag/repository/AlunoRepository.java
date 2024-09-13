package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

    Aluno findByEmail(String email);

    Aluno findByCpf(String cpf);

    Optional<Aluno> findByEmailOrCpf(String email, String cpf);

    //pesquisa email e id diferente do alterado
    Aluno findByEmailAndIdNot(String email, Long id);

    //pesquisa cpf e id diferente do alterado
    Aluno findByCpfAndIdNot(String cpf, Long id);

}

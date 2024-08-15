package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

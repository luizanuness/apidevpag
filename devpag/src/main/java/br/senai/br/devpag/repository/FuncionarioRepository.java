package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Aluno;
import br.senai.br.devpag.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

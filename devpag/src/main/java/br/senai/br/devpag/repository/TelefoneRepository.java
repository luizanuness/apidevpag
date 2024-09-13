package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    List<Telefone> findByPessoaId(Long idPessoa);
}

package br.senai.br.devpag.repository;

import br.senai.br.devpag.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

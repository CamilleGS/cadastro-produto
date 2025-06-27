package com.fatec.cadastro_produto.infrastructure.repository;

import com.fatec.cadastro_produto.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
}

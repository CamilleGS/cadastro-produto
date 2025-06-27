package com.fatec.cadastro_produto.business;

import com.fatec.cadastro_produto.infrastructure.entitys.Usuario;
import com.fatec.cadastro_produto.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }

    public Optional<Usuario> autenticar(String login, String senha) {
        return repository.findByLogin(login)
                .filter(u -> u.getSenha().equals(senha));
    }
}

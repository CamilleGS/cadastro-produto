package com.fatec.cadastro_produto.infrastructure.repository;

import com.fatec.cadastro_produto.infrastructure.entitys.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}

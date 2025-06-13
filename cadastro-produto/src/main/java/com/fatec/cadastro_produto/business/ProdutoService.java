package com.fatec.cadastro_produto.business;

import com.fatec.cadastro_produto.infrastructure.entitys.Produto;
import com.fatec.cadastro_produto.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    //colocar algo dentro put
    public void salvarProduto(Produto produto){
        repository.saveAndFlush(produto);
    }
    //get
    public Produto buscarProdutoPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Id nao encontrado"));
    }

    public List<Produto> buscarTodosProdutos() {
        return repository.findAll();
    }

    public void DeletarProdutoPorId(Integer id){
        repository.deleteById(id);
    }

    public void atualizarProdutoPorId(Integer id, Produto produto){
        // Primeiro, buscamos o produto já existente
        Produto produtoEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id nao encontrado"));

        // Criamos o novo produto com as atualizações desejadas
        Produto produtoAtualizado = Produto.builder()
                .nome(produto.getNome() != null ? produto.getNome() : produtoEntity.getNome())
                .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
                .id(produtoEntity.getId())
                .build();

        // Salvamos e atualizamos no banco
        repository.saveAndFlush(produtoAtualizado);
    }



}

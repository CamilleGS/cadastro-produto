package com.fatec.cadastro_produto.controller;

import com.fatec.cadastro_produto.business.ProdutoService;
import com.fatec.cadastro_produto.infrastructure.entitys.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Produto> BuscarProdutoPorId(@RequestParam Integer id){
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }


    @DeleteMapping
    public ResponseEntity<Void>deletarProdutoPorId(@RequestParam Integer id){
        produtoService.DeletarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProdutoPorId(@RequestParam Integer id, @RequestBody Produto produto){
        produtoService.atualizarProdutoPorId(id, produto);
        return ResponseEntity.ok().build();
    }
}

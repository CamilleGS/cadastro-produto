package com.fatec.cadastro_produto.controller;

import com.fatec.cadastro_produto.business.ProdutoService;
import com.fatec.cadastro_produto.infrastructure.entitys.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller; // <--- Importante: @Controller, não @RestController
import org.springframework.ui.Model; // Para passar dados para o template
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Usa @Controller para retornar views
@RequestMapping("/ui/produtos") // Um novo caminho para as rotas da UI
@RequiredArgsConstructor
public class UiController {

    private final ProdutoService produtoService;

    // Exibe a lista de produtos
    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.buscarTodosProdutos();
        model.addAttribute("produtos", produtos); // Adiciona a lista ao modelo para ser acessada no template
        return "listaProdutos"; // Retorna o nome do template HTML (ex: src/main/resources/templates/listaProdutos.html)
    }

    // Exibe o formulário para adicionar um novo produto
    @GetMapping("/novo")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("produto", new Produto()); // Objeto vazio para preenchimento do formulário
        return "formularioProduto"; // Template para adicionar/editar produto
    }

    // Processa o envio do formulário de adicionar/editar produto
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/ui/produtos"; // Redireciona de volta para a lista após salvar
    }

    // Exibe o formulário para editar um produto existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        model.addAttribute("produto", produto);
        return "formularioProduto"; // Reutiliza o mesmo template do adicionar
    }

    // Deleta um produto e redireciona
    @GetMapping("/deletar/{id}") // Usando GET para simplificar para UI, em produção DELETE seria melhor.
    public String deletarProduto(@PathVariable Integer id) {
        produtoService.DeletarProdutoPorId(id);
        return "redirect:/ui/produtos";
    }
}
package dev.viniefs.GerenciadorProdutos.controller;

import dev.viniefs.GerenciadorProdutos.model.ProdutoModel;
import dev.viniefs.GerenciadorProdutos.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/teste")
    public String testeProduto() { return "Testando o controller"; }

    @PostMapping("/criar")
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


}

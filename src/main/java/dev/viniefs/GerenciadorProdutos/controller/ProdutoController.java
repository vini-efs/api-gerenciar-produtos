package dev.viniefs.GerenciadorProdutos.controller;

import dev.viniefs.GerenciadorProdutos.model.ProdutoModel;
import dev.viniefs.GerenciadorProdutos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@Valid @RequestBody ProdutoModel produto) {
        ProdutoModel novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto de ID número " + novoProduto.getId() + " criado com sucesso!");

    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<ProdutoModel> listaDosProdutos = produtoService.listarProdutos();
        return ResponseEntity.ok(listaDosProdutos);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


}

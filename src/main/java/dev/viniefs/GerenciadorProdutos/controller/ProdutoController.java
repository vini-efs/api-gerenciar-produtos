package dev.viniefs.GerenciadorProdutos.controller;

import dev.viniefs.GerenciadorProdutos.model.ProdutoModel;
import dev.viniefs.GerenciadorProdutos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarPorId(@PathVariable Long id) {
        ProdutoModel produto = produtoService.listarProdutoPorId(id);
        if (produto != null) {
            return ResponseEntity.ok("Produto encontrado: " + produto.getNome());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com ID " + id + " não foi encontrado!");

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        ProdutoModel produto = produtoService.listarProdutoPorId(id);
        if (produto != null) {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com ID " + id + " não pôde ser deletado, pois não existe!");

    }


}

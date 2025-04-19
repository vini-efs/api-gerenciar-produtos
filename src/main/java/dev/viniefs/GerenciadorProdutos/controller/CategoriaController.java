package dev.viniefs.GerenciadorProdutos.controller;

import dev.viniefs.GerenciadorProdutos.model.CategoriaModel;
import dev.viniefs.GerenciadorProdutos.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCategoria(@Valid @RequestBody CategoriaModel categoria) {
        CategoriaModel novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Categoria com ID " + novaCategoria.getId() + " foi criada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaModel>> listarCategoria() {
        List<CategoriaModel> listaDasCategorias = categoriaService.listarCategoria();
        return ResponseEntity.ok(listaDasCategorias);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<String> listarPorId(@PathVariable Long id) {
        CategoriaModel categoriaPorId = categoriaService.listarCategoriaPorId(id);
        if (categoriaPorId != null) {
            return ResponseEntity.ok("Categoria encontrada: " + categoriaPorId.getNome());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria com ID " + id + " não foi encontrado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        CategoriaModel categoria = categoriaService.listarCategoriaPorId(id);
        if (categoria != null) {
            categoriaService.deletarCategoria(id);
            return ResponseEntity.ok("Categoria deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria com ID " + id + " não pôde ser deletada, pois não existe!");
    }
}

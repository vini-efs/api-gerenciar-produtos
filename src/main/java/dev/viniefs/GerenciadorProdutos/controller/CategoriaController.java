package dev.viniefs.GerenciadorProdutos.controller;

import dev.viniefs.GerenciadorProdutos.model.CategoriaModel;
import dev.viniefs.GerenciadorProdutos.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/teste")
    public String testeCategoria() {
        return "Testando controller da categoria";
    }

    @PostMapping("/criar")
    public CategoriaModel criarCategoria(@RequestBody CategoriaModel novaCategoria) {
        return categoriaService.criarCategoria(novaCategoria);
    }

    @GetMapping("/listar")
    public List<CategoriaModel> listarCategoria() {
        return categoriaService.listarCategoria();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }
}

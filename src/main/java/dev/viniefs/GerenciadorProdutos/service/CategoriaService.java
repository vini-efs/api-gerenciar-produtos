package dev.viniefs.GerenciadorProdutos.service;

import dev.viniefs.GerenciadorProdutos.model.CategoriaModel;
import dev.viniefs.GerenciadorProdutos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaModel criarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> listarCategoria() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel listarCategoriaPorId(Long id) {
        Optional<CategoriaModel> listarPorId = categoriaRepository.findById(id);
        return listarPorId.orElse(null);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

}

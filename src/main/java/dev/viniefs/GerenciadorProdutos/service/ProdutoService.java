package dev.viniefs.GerenciadorProdutos.service;

import dev.viniefs.GerenciadorProdutos.model.ProdutoModel;
import dev.viniefs.GerenciadorProdutos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel criarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel listarProdutoPorId(Long id) {
        Optional<ProdutoModel> produtoPorId = produtoRepository.findById(id);
        return produtoPorId.orElse(null);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}

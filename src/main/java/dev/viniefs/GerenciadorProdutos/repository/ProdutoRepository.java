package dev.viniefs.GerenciadorProdutos.repository;

import dev.viniefs.GerenciadorProdutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}

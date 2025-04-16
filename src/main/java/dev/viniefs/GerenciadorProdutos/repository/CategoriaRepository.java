package dev.viniefs.GerenciadorProdutos.repository;

import dev.viniefs.GerenciadorProdutos.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}

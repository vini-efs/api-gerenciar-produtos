package dev.viniefs.GerenciadorProdutos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_produto")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @Size(max = 255, message = "A descrição pode ter no máximo 255 caracteres")
    private String descricao;

    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private int quantidade;

    @Positive(message = "O preço deve ser positivo")
    private float preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;

}
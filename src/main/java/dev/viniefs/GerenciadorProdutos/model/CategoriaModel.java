package dev.viniefs.GerenciadorProdutos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A nome da categoria é obrigatório")
    private String nome;

    @Size(max = 255, message = "A descrição pode ter no máximo 255 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<ProdutoModel> produtos;

}

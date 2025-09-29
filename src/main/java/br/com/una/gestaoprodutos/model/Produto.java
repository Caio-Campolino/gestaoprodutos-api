package br.com.una.gestaoprodutos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    // Define a relação: Muitos Produtos para Uma Categoria [cite: 386]
    @ManyToOne
    @JoinColumn(name = "categoria_id") // Nome da coluna da chave estrangeira na tabela de produtos
    private Categoria categoria;
}
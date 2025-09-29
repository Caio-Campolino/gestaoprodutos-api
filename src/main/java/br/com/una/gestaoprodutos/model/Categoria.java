package br.com.una.gestaoprodutos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // Anotação que informa ao JPA que esta classe é uma entidade do banco de dados
@Data   // Anotação do Lombok para gerar Getters, Setters, toString, etc.
public class Categoria {

    @Id // Marca o campo como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID
    private Long id;

    private String nome;
    private String descricao;
}
// gestaoprodutos/src/main/java/br/com/una/gestaoprodutos/repository/ProdutoRepository.java
package br.com.una.gestaoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.una.gestaoprodutos.model.Produto;

@Repository // Define esta interface como um componente de repositório do Spring
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // A interface JpaRepository já nos fornece todos os métodos básicos de CRUD
    // (Create, Read, Update, Delete), como findAll(), findById(), save(), deleteById(), etc.
}
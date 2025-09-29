package br.com.una.gestaoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.una.gestaoprodutos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
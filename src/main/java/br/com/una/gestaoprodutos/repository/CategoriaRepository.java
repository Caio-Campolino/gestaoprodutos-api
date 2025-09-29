package br.com.una.gestaoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.una.gestaoprodutos.model.Categoria;

@Repository // Anotação que marca a interface como um componente de repositório
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // O JpaRepository já nos fornece os métodos CRUD (save, findById, findAll, deleteById, etc.)
}
package br.com.una.gestaoprodutos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.una.gestaoprodutos.model.Categoria;
import br.com.una.gestaoprodutos.repository.CategoriaRepository;

@Service // Marca a classe como um serviço de negócio
public class CategoriaService {

    @Autowired // Injeta a dependência do repositório automaticamente
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
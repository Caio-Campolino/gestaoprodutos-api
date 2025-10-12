package br.com.una.gestaoprodutos.service;

import br.com.una.gestaoprodutos.handler.ResourceNotFoundException;
import br.com.una.gestaoprodutos.model.Categoria;
import br.com.una.gestaoprodutos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + id));
    }

    public Categoria insert(Categoria obj) {
        return categoriaRepository.save(obj);
    }

    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada com id: " + id);
        }
        // Adicionar tratamento para DataIntegrityViolationException seria o próximo passo
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Long id, Categoria obj) {
        Categoria entity = findById(id); // Reutiliza o findById
        updateData(entity, obj);
        return categoriaRepository.save(entity);
    }

    private void updateData(Categoria entity, Categoria obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
    }
}
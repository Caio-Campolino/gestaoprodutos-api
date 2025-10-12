package br.com.una.gestaoprodutos.service;

import br.com.una.gestaoprodutos.handler.ResourceNotFoundException;
import br.com.una.gestaoprodutos.model.Produto;
import br.com.una.gestaoprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
    }

    public Produto insert(Produto obj) {
        return produtoRepository.save(obj);
    }

    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        produtoRepository.deleteById(id);
    }

    public Produto update(Long id, Produto obj) {
        Produto entity = findById(id); // Reutiliza o findById que já lança exceção
        updateData(entity, obj);
        return produtoRepository.save(entity);
    }

    private void updateData(Produto entity, Produto obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setPreco(obj.getPreco());
        entity.setCategoria(obj.getCategoria());
    }

    public List<Produto> findByCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }
}
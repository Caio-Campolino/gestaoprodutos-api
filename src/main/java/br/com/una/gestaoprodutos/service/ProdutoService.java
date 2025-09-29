// gestaoprodutos/src/main/java/br/com/una/gestaoprodutos/service/ProdutoService.java
package br.com.una.gestaoprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.una.gestaoprodutos.model.Produto;
import br.com.una.gestaoprodutos.repository.ProdutoRepository;

@Service // Define esta classe como um serviço de negócio do Spring
public class ProdutoService {

    @Autowired // Injeta a dependência do ProdutoRepository automaticamente
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long codigo) {
        return produtoRepository.findById(codigo);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarPorId(Long codigo) {
        produtoRepository.deleteById(codigo);
    }

    public Produto atualizar(Long codigo, Produto produto) {
        // Garante que estamos atualizando o produto com o código correto
        produto.setCodigo(codigo);
        return produtoRepository.save(produto);
    }
}
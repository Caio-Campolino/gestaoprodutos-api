package br.com.una.gestaoprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.una.gestaoprodutos.model.Produto;
import br.com.una.gestaoprodutos.repository.ProdutoRepository;

@Service // Marca a classe como um serviço de negócio
public class ProdutoService {

    @Autowired // Injeta a dependência do repositório automaticamente
    private ProdutoRepository produtoRepository;

    /**
     * Salva um novo produto ou atualiza um existente.
     * @param produto O objeto Produto a ser salvo.
     * @return O Produto salvo.
     */
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Retorna uma lista com todos os produtos.
     * @return Lista de todos os produtos.
     */
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    /**
     * Busca um produto pelo seu ID.
     * @param id O ID do produto.
     * @return Um Optional contendo o produto se encontrado, ou vazio caso contrário.
     */
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    /**
     * Deleta um produto pelo seu ID.
     * @param id O ID do produto a ser deletado.
     */
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
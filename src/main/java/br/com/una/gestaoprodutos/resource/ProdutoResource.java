package br.com.una.gestaoprodutos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.una.gestaoprodutos.model.Produto;
import br.com.una.gestaoprodutos.service.ProdutoService;

@RestController // Define a classe como um controlador REST
@RequestMapping("/produtos") // Mapeia todas as requisições para /produtos para este controlador
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com o produto
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        return produtoService.findById(id)
                .map(produtoExistente -> {
                    // Atualiza os campos do produto existente com os detalhes recebidos
                    produtoExistente.setNome(produtoDetails.getNome());
                    produtoExistente.setDescricao(produtoDetails.getDescricao());
                    produtoExistente.setPreco(produtoDetails.getPreco());
                    produtoExistente.setCategoria(produtoDetails.getCategoria());
                    
                    // Salva o produto atualizado
                    Produto produtoAtualizado = produtoService.save(produtoExistente);
                    return ResponseEntity.ok(produtoAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Verifica se o produto existe antes de tentar deletar
        if (!produtoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content, sucesso sem corpo de resposta
    }
}
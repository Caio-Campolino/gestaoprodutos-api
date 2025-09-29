package br.com.una.gestaoprodutos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.una.gestaoprodutos.model.Produto;
import br.com.una.gestaoprodutos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarPorCodigo(@PathVariable Long codigo) {
        return produtoService.buscarPorId(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long codigo, @RequestBody Produto produto) {
        if (!produtoService.buscarPorId(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoService.atualizar(codigo, produto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
        if (!produtoService.buscarPorId(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deletarPorId(codigo);
        return ResponseEntity.noContent().build();
    }
}
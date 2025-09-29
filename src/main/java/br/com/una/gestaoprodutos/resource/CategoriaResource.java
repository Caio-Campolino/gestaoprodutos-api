package br.com.una.gestaoprodutos.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.una.gestaoprodutos.model.Categoria;
import br.com.una.gestaoprodutos.service.CategoriaService;

@RestController // Define a classe como um controlador REST
@RequestMapping("/categorias") // Mapeia todas as requisições para /categorias para este controlador
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return categoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Adicione os métodos para PUT (atualizar) e DELETE (remover)
}
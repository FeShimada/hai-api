package org.acme.produto.repository;

import java.util.UUID;

import org.acme.produto.orm.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author Felipe Shimada
 * @version 1.0
 */
@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    
    public Produto findById(UUID uuid) {
        return Produto.findById(uuid);
    }
}

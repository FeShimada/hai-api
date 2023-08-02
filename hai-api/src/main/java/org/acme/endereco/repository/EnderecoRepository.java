package org.acme.endereco.repository;

import java.util.UUID;

import org.acme.endereco.orm.Endereco;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author Felipe Shimada
 * @version 1.0
 */
@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    public Endereco findById(UUID uuid) {
        return Endereco.findById(uuid);
    }
}

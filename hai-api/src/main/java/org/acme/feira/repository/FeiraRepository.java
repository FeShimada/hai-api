package org.acme.feira.repository;

import java.util.UUID;

import org.acme.feira.orm.Feira;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author Felipe Shimada
 * @version 1.0
 */
@ApplicationScoped
public class FeiraRepository implements PanacheRepository<Feira> {
    
    public Feira findById(UUID uuid) {
        return Feira.findById(uuid);
    }
}

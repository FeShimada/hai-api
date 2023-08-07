package org.acme.produtofeira.orm;

import java.util.UUID;

import org.acme.orm.BaseEntity;

import jakarta.persistence.*;


/**
 * Representação da entidade "produto_feira"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@Entity
@Table(name = "produto_feira")
public class ProdutoFeira extends BaseEntity {

     /**
     * Id do produto.
     */
    @Id
    @GeneratedValue
    @Column(name = "id_produto", nullable = false)
    private UUID idProduto;
    
}

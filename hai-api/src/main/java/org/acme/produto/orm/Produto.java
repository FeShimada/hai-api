package org.acme.produto.orm;

import java.util.UUID;

import org.acme.orm.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

/**
 * Representação da entidade "produto"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@Entity
@Table(name = "produto")
public class Produto extends BaseEntity {
    
    /**
     * Id do produto.
     */
    @Id
    @GeneratedValue
    @Column(name = "id_produto", nullable = false)
    private UUID idProduto;

    /**
     * Preço do produto.
     */
    @Column(name="nr_preco")
    private Double nrPreco;

    /**
     * Nome do produto.
     */
    @Column(name = "nm_produto", nullable = false)
    private String nmProduto;

    /**
     * Descrição do produto.
     */
    @Column(name = "ds_produto", nullable = false)
    private String dsProduto;

    /**
     * Imagem
     */
    @Column(name = "ds_imagem")
    private String dsImagem;

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public Double getNrPreco() {
        return nrPreco;
    }

    public void setNrPreco(Double nrPreco) {
        this.nrPreco = nrPreco;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

}

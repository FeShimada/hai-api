package org.acme.produto.dto;



/**
 * Representação da entidade "produto"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
public class ProdutoDto {
    
    /**
     * Id do produto.
     */
    private String idProduto;

    /**
     * Preço do produto.
     */
    private Double nrPreco;

    /**
     * Nome do produto.
     */
    private String nmProduto;

    /**
     * Descrição do produto.
     */
    private String dsProduto;

    /**
     * Imagem
     */
    private String dsImagem;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
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

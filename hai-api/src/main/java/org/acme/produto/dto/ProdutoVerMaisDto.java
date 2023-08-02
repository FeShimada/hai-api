package org.acme.produto.dto;

import java.util.List;

import org.acme.feira.dto.FeiraDto;

public class ProdutoVerMaisDto extends ProdutoDto {
    /**
     * Quantidade do produto.
     */
    private Integer nrQuantidade;

    /**
     * Lista de feiras em que o produto está presente.
     */
    private List<FeiraDto> feiras;

    public Integer getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(Integer nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    public List<FeiraDto> getFeiras() {
        return feiras;
    }

    public void setFeiras(List<FeiraDto> feiras) {
        this.feiras = feiras;
    }
}

package org.acme.endereco.dto;

/**
 * Representação da entidade "endereco"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
public class EnderecoDto {
    
    /**
     * Id do produto.
     */
    private String idEndereco;

    private String rua;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String estado;

    /**
     * Situação do registro
     */
    private Integer stRegistro;

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(Integer stRegistro) {
        this.stRegistro = stRegistro;
    }


}

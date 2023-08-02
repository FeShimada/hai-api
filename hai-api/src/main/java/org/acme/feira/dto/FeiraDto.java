package org.acme.feira.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.acme.endereco.dto.EnderecoDto;
import org.acme.enumerations.DiaSemana;
import org.acme.enumerations.SituacaoRegistroEnum;
import org.acme.produto.dto.ProdutoDto;

/**
 * Representação da entidade "feira"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
public class FeiraDto {

    /**
     * Id da feira.
     */
    private String idFeira;

    /**
     * Nome da feira.
     */
    private String nmFeira;

    /**
     * Hora início da feira
     */
    private LocalDate hrInicio;

    /**
     * Hora término da feira
     */
    private LocalDate hrTermino;

    /**
     * Dias da semana em que a feira ocorre.
     */
    private Set<DiaSemana> diasSemana;

    /**
     * Endereço da feira.
     */
    private EnderecoDto endereco;

    /**
     * Lista de produtos presentes na feira.
     */
    private List<ProdutoDto> produtos;

    /**
     * Situação do registro
     */
    private SituacaoRegistroEnum stRegistro;

    public String getIdFeira() {
        return idFeira;
    }

    public void setIdFeira(String idFeira) {
        this.idFeira = idFeira;
    }

    public String getNmFeira() {
        return nmFeira;
    }

    public void setNmFeira(String nmFeira) {
        this.nmFeira = nmFeira;
    }

    public LocalDate getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(LocalDate hrInicio) {
        this.hrInicio = hrInicio;
    }

    public LocalDate getHrTermino() {
        return hrTermino;
    }

    public void setHrTermino(LocalDate hrTermino) {
        this.hrTermino = hrTermino;
    }

    public Set<DiaSemana> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(Set<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public SituacaoRegistroEnum getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(SituacaoRegistroEnum stRegistro) {
        this.stRegistro = stRegistro;
    }

}

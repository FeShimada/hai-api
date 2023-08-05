package org.acme.feira.dto;

import java.util.Set;

import org.acme.endereco.dto.EnderecoDto;
import org.acme.enumerations.SituacaoRegistroEnum;

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
    private String hrInicio;

    /**
     * Hora término da feira
     */
    private String hrTermino;

    /**
     * Dias da semana em que a feira ocorre.
     */
    private Set<Integer> diasSemana;

    /**
     * Endereço da feira.
     */
    private EnderecoDto endereco;

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


    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public SituacaoRegistroEnum getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(SituacaoRegistroEnum stRegistro) {
        this.stRegistro = stRegistro;
    }

    public String getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(String hrInicio) {
        this.hrInicio = hrInicio;
    }

    public String getHrTermino() {
        return hrTermino;
    }

    public void setHrTermino(String hrTermino) {
        this.hrTermino = hrTermino;
    }

    public Set<Integer> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(Set<Integer> diasSemana) {
        this.diasSemana = diasSemana;
    }

}

package org.acme.feira.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.acme.endereco.dto.EnderecoDto;
import org.acme.enumerations.DiaSemana;
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
    private LocalDateTime hrInicio;

    /**
     * Hora término da feira
     */
    private LocalDateTime hrTermino;

    /**
     * Dias da semana em que a feira ocorre.
     */
    private Set<DiaSemana> diasSemana;

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

    public LocalDateTime getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(LocalDateTime hrInicio) {
        this.hrInicio = hrInicio;
    }

    public LocalDateTime getHrTermino() {
        return hrTermino;
    }

    public void setHrTermino(LocalDateTime hrTermino) {
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

    public SituacaoRegistroEnum getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(SituacaoRegistroEnum stRegistro) {
        this.stRegistro = stRegistro;
    }

}

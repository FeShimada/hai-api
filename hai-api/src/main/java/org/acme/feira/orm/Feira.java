package org.acme.feira.orm;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.acme.endereco.orm.Endereco;
import org.acme.enumerations.DiaSemana;
import org.acme.orm.BaseEntity;
import org.acme.produto.orm.Produto;

import jakarta.persistence.*;

/**
 * Representação da entidade "feira"
 *
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@Entity
@Table(name = "feira")
public class Feira extends BaseEntity {
    

    /**
     * Id da feira.
     */
    @Id
    @GeneratedValue
    @Column(name = "id_feira", nullable = false)
    private UUID idFeira;

    /**
     * Nome da feira.
     */
    @Column(name="nm_feira")
    private String nmFeira;

    /**
     * Hora início da feira
     */
    @Column(name="hr_inicio")
    private LocalDate hrInicio;

    /**
     * Hora término da feira
     */
    @Column(name="hr_termino")
    private LocalDate hrTermino;

    /**
     * Dias da semana em que a feira ocorre.
     */
    @ElementCollection(targetClass = DiaSemana.class)
    @CollectionTable(name = "feira_dias_semana", joinColumns = @JoinColumn(name = "id_feira"))
    @Column(name = "dia_semana", nullable = false)
    private Set<DiaSemana> diasSemana;

    /**
     * Endereço da feira.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    /**
     * Lista de produtos presentes na feira.
     */
    @ManyToMany(mappedBy = "feiras")
    private List<Produto> produtos;

    public UUID getIdFeira() {
        return idFeira;
    }

    public void setIdFeira(UUID idFeira) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}

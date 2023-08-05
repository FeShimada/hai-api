package org.acme.feira.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.acme.commons.converter.AbstractConverter;
import org.acme.endereco.converter.EnderecoConverter;
import org.acme.enumerations.DiaSemana;
import org.acme.feira.dto.FeiraDto;
import org.acme.feira.orm.Feira;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@RequestScoped
public class FeiraConverter implements AbstractConverter<Feira, FeiraDto> {

    @Inject
    EnderecoConverter enderecoConverter;
    
    @Override
    public Feira dtoToOrm(FeiraDto dto, Feira orm) {
        if (dto.getIdFeira() != null) {
            orm.setIdFeira(UUID.fromString(dto.getIdFeira()));
        }
        orm.setNmFeira(dto.getNmFeira());
        orm.setHrInicio(dto.getHrInicio());
        orm.setHrTermino(dto.getHrTermino());

        Set<Integer> diasSemanaDto = dto.getDiasSemana();
        if (diasSemanaDto != null) {
            Set<DiaSemana> diasSemanaOrm = new HashSet<>();
            for (Integer diaInt : diasSemanaDto) {
                DiaSemana diaSemana = DiaSemana.valueOf(diaInt);
                diasSemanaOrm.add(diaSemana);
            }
            orm.setDiasSemana(diasSemanaOrm);
        }

        return orm;
    }

    @Override
    public Feira dtoToOrm(FeiraDto dto) {
        return dtoToOrm(dto, new Feira());
    }

    @Override
    public FeiraDto ormToDto(Feira orm, FeiraDto dto) {
        dto.setIdFeira(orm.getIdFeira().toString());
        dto.setNmFeira(orm.getNmFeira());
        dto.setHrInicio(orm.getHrInicio());
        dto.setHrTermino(orm.getHrTermino());
       
        
        Set<DiaSemana> diasSemanaOrm = orm.getDiasSemana();
        if (diasSemanaOrm != null) {
            Set<Integer> diasSemanaDto = new HashSet<>();
            for (DiaSemana diaSemana : diasSemanaOrm) {
                int valorDia = diaSemana.getValue(); // Supondo que você tenha um método getValue() na enumeração DiaSemana que retorna o valor inteiro correspondente.
                diasSemanaDto.add(valorDia);
            }
            dto.setDiasSemana(diasSemanaDto);
        }


        dto.setEndereco(enderecoConverter.ormToDto(orm.getEndereco()));

        return dto;
    }

    @Override
    public FeiraDto ormToDto(Feira orm) {
        return ormToDto(orm, new FeiraDto());
    }

    @Override
    public List<Feira> dtoListToOrmList(List<FeiraDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    @Override
    public List<FeiraDto> ormListToDtoList(List<Feira> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}

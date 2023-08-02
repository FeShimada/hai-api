package org.acme.endereco.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.acme.commons.converter.AbstractConverter;
import org.acme.endereco.dto.EnderecoDto;
import org.acme.endereco.orm.Endereco;

import jakarta.enterprise.context.RequestScoped;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@RequestScoped
public class EnderecoConverter implements AbstractConverter<Endereco, EnderecoDto> {
    
    @Override
    public Endereco dtoToOrm(EnderecoDto dto, Endereco orm) {
        if (dto.getIdEndereco() != null) {
            orm.setIdEndereco(UUID.fromString(dto.getIdEndereco()));
        }

        orm.setRua(dto.getRua());
        orm.setNumero(dto.getNumero());
        orm.setBairro(dto.getBairro());
        orm.setCidade(dto.getCidade());
        orm.setEstado(dto.getEstado());

        return orm;
    }

    @Override
    public Endereco dtoToOrm(EnderecoDto dto) {
        return dtoToOrm(dto, new Endereco());
    }

    @Override
    public EnderecoDto ormToDto(Endereco orm, EnderecoDto dto) {
        dto.setIdEndereco(orm.getIdEndereco().toString());
        dto.setRua(orm.getRua());
        dto.setNumero(orm.getNumero());
        dto.setBairro(orm.getBairro());
        dto.setCidade(orm.getCidade());
        dto.setEstado(orm.getEstado());

        return dto;
    }

    @Override
    public EnderecoDto ormToDto(Endereco orm) {
        return ormToDto(orm, new EnderecoDto());
    }

    @Override
    public List<Endereco> dtoListToOrmList(List<EnderecoDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    @Override
    public List<EnderecoDto> ormListToDtoList(List<Endereco> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}

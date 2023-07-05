package org.acme.produto.converter;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.commons.converter.AbstractConverter;
import org.acme.produto.dto.ProdutoDto;
import org.acme.produto.orm.Produto;

import jakarta.enterprise.context.RequestScoped;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@RequestScoped
public class ProdutoConverter implements AbstractConverter<Produto, ProdutoDto> {
    
    @Override
    public Produto dtoToOrm(ProdutoDto dto, Produto orm) {
        if (dto.getIdProduto() != null) {
            orm.setIdProduto(UUID.fromString(dto.getIdProduto()));
        }
        orm.setNrPreco(dto.getNrPreco());
        orm.setNmProduto(dto.getNmProduto());
        orm.setDsProduto(dto.getDsProduto());
        orm.setDsImagem(dto.getDsImagem());

        return orm;
    }

    @Override
    public Produto dtoToOrm(ProdutoDto dto) {
        return dtoToOrm(dto, new Produto());
    }

    @Override
    public ProdutoDto ormToDto(Produto orm, ProdutoDto dto) {
        dto.setIdProduto(orm.getIdProduto().toString());
        dto.setNrPreco(orm.getNrPreco());
        dto.setNmProduto(orm.getNmProduto());
        dto.setDsProduto(orm.getDsProduto());
        dto.setDsImagem(orm.getDsImagem());
        return dto;
    }

    @Override
    public ProdutoDto ormToDto(Produto orm) {
        return ormToDto(orm, new ProdutoDto());
    }

    @Override
    public List<Produto> dtoListToOrmList(List<ProdutoDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDto> ormListToDtoList(List<Produto> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}

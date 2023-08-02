package org.acme.produto.converter;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import org.acme.commons.converter.AbstractConverter;
import org.acme.produto.dto.ProdutoVerMaisDto;
import org.acme.produto.orm.Produto;

import jakarta.enterprise.context.RequestScoped;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 */
@RequestScoped
public class ProdutoVerMaisConverter implements AbstractConverter<Produto, ProdutoVerMaisDto> {
    
    @Override
    public Produto dtoToOrm(ProdutoVerMaisDto dto, Produto orm) {
        if (dto.getIdProduto() != null) {
            orm.setIdProduto(UUID.fromString(dto.getIdProduto()));
        }
        orm.setNrPreco(dto.getNrPreco());
        orm.setNmProduto(dto.getNmProduto());
        orm.setDsProduto(dto.getDsProduto());
        orm.setDsImagem(dto.getDsImagem());

        orm.setNrQuantidade(dto.getNrQuantidade());

        return orm;
    }

    @Override
    public Produto dtoToOrm(ProdutoVerMaisDto dto) {
        return dtoToOrm(dto, new Produto());
    }

    @Override
    public ProdutoVerMaisDto ormToDto(Produto orm, ProdutoVerMaisDto dto) {
        dto.setIdProduto(orm.getIdProduto().toString());
        dto.setNrPreco(orm.getNrPreco());
        dto.setNmProduto(orm.getNmProduto());
        dto.setDsProduto(orm.getDsProduto());
        dto.setDsImagem(orm.getDsImagem());

        dto.setNrQuantidade(orm.getNrQuantidade());

        return dto;
    }

    @Override
    public ProdutoVerMaisDto ormToDto(Produto orm) {
        return ormToDto(orm, new ProdutoVerMaisDto());
    }

    @Override
    public List<Produto> dtoListToOrmList(List<ProdutoVerMaisDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoVerMaisDto> ormListToDtoList(List<Produto> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}

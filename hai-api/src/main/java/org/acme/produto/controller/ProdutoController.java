package org.acme.produto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.acme.enumerations.SituacaoRegistroEnum;
import org.acme.feira.converter.FeiraConverter;
import org.acme.feira.dto.FeiraDto;
import org.acme.feira.orm.Feira;
import org.acme.feira.repository.FeiraRepository;
import org.acme.produto.converter.ProdutoConverter;
import org.acme.produto.converter.ProdutoVerMaisConverter;
import org.acme.produto.dto.ProdutoDto;
import org.acme.produto.dto.ProdutoVerMaisDto;
import org.acme.produto.orm.Produto;
import org.acme.produto.repository.ProdutoRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 * @version 1.0
 */
@RequestScoped
public class ProdutoController {
    
    @Inject
    ProdutoConverter produtoConverter;

    @Inject
    ProdutoVerMaisConverter produtoVerMaisConverter;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    FeiraRepository feiraRepository;

    @Inject
    FeiraConverter feiraConverter;

    @Transactional
    public ProdutoDto create(ProdutoVerMaisDto produtoDto) {
        Produto produto = produtoVerMaisConverter.dtoToOrm(produtoDto);
        produtoRepository.persist(produto);

        List<Feira> feirasAssociadas = new ArrayList<>();
        if (produtoDto.getFeiras() != null) {
            for (FeiraDto feiraDto : produtoDto.getFeiras()) {
                Feira feira = feiraRepository.findById(UUID.fromString(feiraDto.getIdFeira()));
                if (feira != null) {
                    feirasAssociadas.add(feira);
                } else {
                    // Tratar o caso onde o ID da feira é inválido ou não existe no banco de dados
                    // Por exemplo, lançar uma exceção ou simplesmente ignorar a feira desconhecida.
                }
            }
        }
        produto.setFeiras(feirasAssociadas);

        return produtoVerMaisConverter.ormToDto(produto, produtoDto);
    }

    public ProdutoDto retrieve(UUID uuid) {

        Produto produto = produtoRepository.findById(uuid);
        if(produto == null){
            throw new NotFoundException("Produto não encontrado");
        }

        ProdutoVerMaisDto produtoDto = produtoVerMaisConverter.ormToDto(produto);

        produtoDto.setFeiras(feiraConverter.ormListToDtoList(produto.getFeiras()));

        return produtoDto;
    }
    
    public List<ProdutoDto> retrieve() {
        List<Produto> produtos = produtoRepository.findAll().list();
        return produtoConverter.ormListToDtoList(produtos);
    }

    @Transactional
    public ProdutoDto update(ProdutoVerMaisDto produtoDto) {
        Produto produto = produtoRepository.findById(UUID.fromString(produtoDto.getIdProduto()));
        if(produto == null){
            throw new NotFoundException("Produto não encontrado");
        }

        produtoDto.getFeiras().forEach(feira -> {
            if (feira.getStRegistro() == SituacaoRegistroEnum.CREATE) {
                //feiraController.create(feira, inspecao);
            } else if (feira.getStRegistro() == SituacaoRegistroEnum.UPDATE) {
                //feiraController.update(feira);
            } else if (feira.getStRegistro() == SituacaoRegistroEnum.DELETE) {
                //feiraController.delete(UUID.fromString(feira.getIdInspecaoResultado()));
            }
        });

        produtoVerMaisConverter.dtoToOrm(produtoDto, produto);
        produtoRepository.persist(produto);
        return produtoDto;
    }

    @Transactional
    public boolean delete(UUID uuid) {
        try {
            Produto produto = produtoRepository.findById(uuid);
            if(produto == null) {
                throw new NotFoundException("Produto não encontrado");
            }
            produtoRepository.delete(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

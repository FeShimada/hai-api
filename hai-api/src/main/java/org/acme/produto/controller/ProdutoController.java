package org.acme.produto.controller;

import java.util.List;
import java.util.UUID;

import org.acme.produto.converter.ProdutoConverter;
import org.acme.produto.dto.ProdutoDto;
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
    ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoDto create(ProdutoDto produtoDto) {
        Produto produto = produtoConverter.dtoToOrm(produtoDto);
        produtoRepository.persist(produto);
        return produtoConverter.ormToDto(produto, produtoDto);
    }

    public ProdutoDto retrieve(UUID uuid) {
        return produtoConverter.ormToDto(produtoRepository.findById(uuid));
    }
    
    public List<Produto> retrieve() {

        List<Produto> produtos = produtoRepository.findAll().list();

        return produtos;
    }

    @Transactional
    public ProdutoDto update(ProdutoDto produtoDto) {
        Produto produto = produtoRepository.findById(UUID.fromString(produtoDto.getIdProduto()));
        if(produto == null){
            throw new NotFoundException("Produto não encontrado");
        }
        produtoConverter.dtoToOrm(produtoDto, produto);
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

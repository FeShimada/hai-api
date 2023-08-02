package org.acme.feira.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.acme.endereco.converter.EnderecoConverter;
import org.acme.endereco.orm.Endereco;
import org.acme.endereco.repository.EnderecoRepository;
import org.acme.enumerations.SituacaoRegistroEnum;
import org.acme.feira.converter.FeiraConverter;
import org.acme.feira.dto.FeiraDto;
import org.acme.feira.orm.Feira;
import org.acme.feira.repository.FeiraRepository;
import org.acme.produto.dto.ProdutoDto;
import org.acme.produto.orm.Produto;
import org.acme.produto.repository.ProdutoRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

/**
 * @author Felipe Shimada <felipeshimada2@gmail.com>
 * @version 1.0
 */
@RequestScoped
public class FeiraController {

    @Inject
    FeiraConverter feiraConverter;

    @Inject
    FeiraRepository feiraRepository;

    @Inject
    EnderecoConverter enderecoConverter;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public FeiraDto create(FeiraDto feiraDto) {
        Feira feira = feiraConverter.dtoToOrm(feiraDto);

        feiraRepository.persist(feira);

        List<Produto> produtosAssociados = new ArrayList<>();
        if (feiraDto.getProdutos() != null) {
            for (ProdutoDto produtoDto : feiraDto.getProdutos()) {
                Produto produto = produtoRepository.findById(UUID.fromString(produtoDto.getIdProduto()));
                if (produto != null) {
                    produtosAssociados.add(produto);
                } else {
                    // Tratar o caso onde o ID da feira é inválido ou não existe no banco de dados
                    // Por exemplo, lançar uma exceção ou simplesmente ignorar a feira desconhecida.
                }
            }
        }
        feira.setProdutos(produtosAssociados);        

        setEndereco(feira, feiraDto);

        return feiraConverter.ormToDto(feira, feiraDto);
    }

    public List<FeiraDto> retrieve() {
        List<Feira> feiras = feiraRepository.findAll().list();
        System.out.println("AQUIIIIIIIIIIIIIIIIIIIIII");
        for(Feira feira : feiras) {
            System.out.println(feira.getProdutos());
            for(Produto produto : feira.getProdutos()) {
                System.out.println("AQUIIIIIIIIIIIIIIIIIIIIII");
                System.out.println(produto.getIdProduto());
            }
        }
        
        List<FeiraDto> feiraDtoList = feiraConverter.ormListToDtoList(feiras);
        return feiraDtoList;
    }

    @Transactional
    public void setEndereco(Feira feira, FeiraDto feiraDto) {
        
        if(feiraDto.getEndereco().getStRegistro() == SituacaoRegistroEnum.CREATE.ordinal()) {
            Endereco endereco = enderecoConverter.dtoToOrm(feiraDto.getEndereco());
            enderecoRepository.persist(endereco);
            feira.setEndereco(endereco);
        } else if(feiraDto.getEndereco().getStRegistro() == SituacaoRegistroEnum.UPDATE.ordinal()) {
            Endereco endereco = Endereco.findById(UUID.fromString(feiraDto.getEndereco().getIdEndereco()));
            enderecoConverter.dtoToOrm(feiraDto.getEndereco(), endereco);
            enderecoRepository.persist(endereco);
            feira.setEndereco(endereco);
        } else if(feiraDto.getEndereco().getStRegistro() == SituacaoRegistroEnum.DELETE.ordinal()) {
            Endereco endereco = Endereco.findById(UUID.fromString(feiraDto.getEndereco().getIdEndereco()));
            Endereco.deleteById(endereco.getIdEndereco());
        }
        
    }
    
}

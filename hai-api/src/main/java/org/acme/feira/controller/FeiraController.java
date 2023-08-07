package org.acme.feira.controller;

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

        setEndereco(feira, feiraDto);

        return feiraConverter.ormToDto(feira, feiraDto);
    }

    public List<FeiraDto> retrieve() {
        List<Feira> feiras = feiraRepository.findAll().list();
        
        List<FeiraDto> feiraDtoList = feiraConverter.ormListToDtoList(feiras);
        return feiraDtoList;
    }

    // será utilizado para buscar todas as feiras relacionadas com aquele produto!
    // /produtos/{produtoId}/feiras
    public List<FeiraDto> retrieveAllFeirasByProdutosId(UUID produtoId) {
        if(produtoRepository.findById(produtoId) == null) {
            throw new NotFoundException("Not found produto  with id = " + produtoId);
        }

        List<Feira> feiras = feiraRepository.find("produtos.idProduto", produtoId).list();
        return feiraConverter.ormListToDtoList(feiras);
    }

    public FeiraDto retrieve(UUID uuid) {

        Feira feira = feiraRepository.findById(uuid);
        if(feira == null){
            throw new NotFoundException("Feira não encontrado");
        }

        FeiraDto feiraDto = feiraConverter.ormToDto(feira);

        return feiraDto;
    }

    @Transactional
    public FeiraDto update(FeiraDto feiraDto) {
        Feira feira = feiraRepository.findById(UUID.fromString(feiraDto.getIdFeira()));
        if(feira == null){
            throw new NotFoundException("Feira não encontrada");
        }

        setEndereco(feira, feiraDto);

        feiraConverter.dtoToOrm(feiraDto, feira);
        feiraRepository.persist(feira);
        return feiraDto;
    }

    @Transactional
    public boolean delete(UUID uuid) {
        try {
            Feira feira = feiraRepository.findById(uuid);
            if(feira == null) {
                throw new NotFoundException("Feira não encontrada");
            }

            for (Produto produto : feira.getProdutos()) {
                produto.getFeiras().remove(feira);
            }

            feiraRepository.delete(feira);
            return true;
        } catch (Exception e) {
            return false;
        }
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

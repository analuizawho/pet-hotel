package com.analuizawho.pet_hotel.service;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.exception.ErrosDaApiException;
import com.analuizawho.pet_hotel.mapper.PetMapper;
import com.analuizawho.pet_hotel.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetMapper petMapper;

    public DadosDetalhamentoPet cadastrar(@RequestBody DadosCadastroPet dto){
        var newPet = petMapper.paraPet(dto);
        validarCampo(dto);
        newPet.setAtivo();
        var pet = petRepository.save(newPet);

        return petMapper.paraDetalhamento(pet);
    }

    public List<DadosListagemPet> listar(){
        var pet = petRepository.findAllByAtivoTrue();
        return petMapper.paraListagemDTO(pet);
    }

    public DadosDetalhamentoPet atualizar(Long id, DadosAtualizarPet dto){
        var pet = petRepository.getReferenceById(id);
        pet.atualizarInformacoes(dto);
        pet = petRepository.save(pet);
        return petMapper.paraDetalhamento(pet);
    }

    public void reativar(Long id){
        var pet = petRepository.getReferenceById(id);
        pet.setAtivo();
    }

    public DadosDetalhamentoPet detalhar(Long id){
        var pet = petRepository.getReferenceById(id);
        return petMapper.paraDetalhamento(pet);
    }

    public void excluir(Long id){
        petRepository.deleteById(id);
    }

    public void inativar(Long id){
        var pet = petRepository.getReferenceById(id);
        pet.setInativo();
    }

    private void validarCampo(DadosCadastroPet dadosPet) {
        if (dadosPet.nome().matches(".*\\d.*")) {
            throw new ErrosDaApiException("nome", "Favor inserir apenas letras.");
        }

        if (dadosPet.doenca().matches(".*\\d.*")) {
            throw new ErrosDaApiException("doenca", "Favor inserir apenas letras.");
        }

        if (dadosPet.raca().matches(".*\\d.*")) {
            throw new ErrosDaApiException("raca", "Favor inserir apenas letras.");
        }
    }
}

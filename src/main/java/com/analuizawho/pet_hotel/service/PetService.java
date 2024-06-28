package com.analuizawho.pet_hotel.service;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.mapper.PetMapper;
import com.analuizawho.pet_hotel.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetMapper petMapper;

    public DadosDetalhamentoPet cadastrar(@RequestBody DadosCadastroPet dto, UriComponentsBuilder uriBuilder){
        var newPet = this.petMapper.paraPet(dto);
        var pet = this.petRepository.save(newPet);

        return petMapper.paraDetalhamento(pet);
    }

    public List<DadosListagemPet> listar(){
        var pet = this.petRepository.findAll();
        return petMapper.paraListagemDTO(pet);
    }

    public DadosDetalhamentoPet atualizar(Long id, DadosAtualizarPet dto){
        var pet = this.petRepository.getReferenceById(id);
        pet.atualizarInformacoes(dto);
        pet = petRepository.save(pet);
        return petMapper.paraDetalhamento(pet);
    }

    public void reativar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        pet.reativar();
    }

    public DadosDetalhamentoPet detalhar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        return petMapper.paraDetalhamento(pet);
    }

    public void excluir(Long id){
        petRepository.deleteById(id);
    }

    public void inativar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        pet.inativar();
    }
}

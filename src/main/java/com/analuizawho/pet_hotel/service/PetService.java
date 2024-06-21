package com.analuizawho.pet_hotel.service;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.mapper.PetMapper;
import com.analuizawho.pet_hotel.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class PetService {

    PetRepository petRepository;

    PetMapper petMapper;

    public DadosDetalhamentoPet cadastrar(@RequestBody DadosCadastroPet dto, UriComponentsBuilder uriBuilder){
        var newPet = this.petMapper.cadastroParaPet(dto);
        var pet = this.petRepository.save(newPet);

        return this.petMapper.petParaDetalhamento(pet);
    }

    public List<DadosListagemPet> listar(){
        var pet = this.petRepository.findAll();
        return this.petMapper.petParaListagem(pet);
    }

    public DadosDetalhamentoPet atualizar(Long id, DadosAtualizarPet dto){
        var pet = this.petRepository.getReferenceById(id);
        pet.atualizarInformacoes(dto);
        pet = petRepository.save(pet);
        return this.petMapper.petParaDetalhamento(pet);
    }

    public void reativar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        pet.reativar();
    }

    public DadosDetalhamentoPet detalhar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        return this.petMapper.petParaDetalhamento(pet);
    }

    public void excluir(Long id){
        petRepository.deleteById(id);
    }

    public void inativar(Long id){
        var pet = this.petRepository.getReferenceById(id);
        pet.inativar();
    }
}

package com.analuizawho.pet_hotel.service;

import com.analuizawho.pet_hotel.dto.*;
import com.analuizawho.pet_hotel.entities.Hospedagem;
import com.analuizawho.pet_hotel.entities.Pet;
import com.analuizawho.pet_hotel.exception.ErrosDaApiException;
import com.analuizawho.pet_hotel.mapper.HospedagemMapper;
import com.analuizawho.pet_hotel.repository.HospedagemRepository;
import com.analuizawho.pet_hotel.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    HospedagemMapper hospedagemMapper;

    @Autowired
    HospedagemRepository hospedagemRepository;

    @Autowired
    PetRepository petRepository;

    public DadosDetalhamentoHospedagem checkIn(DadosCheckInHospedagem dto){
        Pet pet = petRepository.findById(dto.petId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        var newHospedagem = hospedagemMapper.paraHospedagem(dto);
        newHospedagem.setPet(pet);
        var hospedagem = hospedagemRepository.save(newHospedagem);

        return hospedagemMapper.paraDetalhamento(hospedagem);
    }

    public List<DadosListagemHospedagem> listar(){
        var hospedagem = hospedagemRepository.findAll();
        return hospedagemMapper.paraListagem(hospedagem);
    }

    public DadosDetalhamentoHospedagem atualizar(Long id, DadosAtualizarHospedagem dto){
        var hospedagem = hospedagemRepository.getReferenceById(id);
        hospedagem.atualizarInformacoes(dto);
        hospedagem = hospedagemRepository.save(hospedagem);
        return hospedagemMapper.paraDetalhamento(hospedagem);
    }


}

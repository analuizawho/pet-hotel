package com.analuizawho.pet_hotel.service;

import com.analuizawho.pet_hotel.dto.DadosCheckInHospedagem;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoHospedagem;
import com.analuizawho.pet_hotel.entities.Hospedagem;
import com.analuizawho.pet_hotel.entities.Pet;
import com.analuizawho.pet_hotel.mapper.HospedagemMapper;
import com.analuizawho.pet_hotel.repository.HospedagemRepository;
import com.analuizawho.pet_hotel.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

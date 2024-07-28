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
                .orElseThrow(() -> new ErrosDaApiException("petId", "Insira um petId válido"));
        var newHospedagem = hospedagemMapper.paraHospedagem(dto);
        newHospedagem.setPet(pet);
        validarData(newHospedagem);
        var hospedagem = hospedagemRepository.save(newHospedagem);

        return hospedagemMapper.paraDetalhamento(hospedagem);
    }

    public List<DadosListagemHospedagem> listar(){
        var hospedagem = hospedagemRepository.findAll();
        return hospedagemMapper.paraListagem(hospedagem);
    }

    public DadosDetalhamentoHospedagem detalhar(Long id){
        var hospedagem = hospedagemRepository.getReferenceById(id);
        return hospedagemMapper.paraDetalhamento(hospedagem);
    }

    public DadosDetalhamentoHospedagem atualizar(Long id, DadosAtualizarHospedagem dto){
        var hospedagem = hospedagemRepository.getReferenceById(id);
        hospedagem.atualizarInformacoes(dto);
        validarData(hospedagem);
        hospedagem = hospedagemRepository.save(hospedagem);
        return hospedagemMapper.paraDetalhamento(hospedagem);
    }

    public DadosDetalhamentoHospedagem adicionarServicoExtra(Long id, DadosAtualizarServicoExtra dto){
        var hospedagem = hospedagemRepository.getReferenceById(id);
        hospedagem.atualizarServicoExtra(dto);
        hospedagem = hospedagemRepository.save(hospedagem);
        return hospedagemMapper.paraDetalhamento(hospedagem);
    }

    public void excluir(Long id){
        hospedagemRepository.deleteById(id);
    }

    public void validarData(Hospedagem hospedagem){
        if(hospedagem.getCheckInData().isAfter(hospedagem.getCheckOutData())){
            throw new ErrosDaApiException("checkIn/checkOut", "O checkIn não pode ser antes do checkOut");
        }
    }

}

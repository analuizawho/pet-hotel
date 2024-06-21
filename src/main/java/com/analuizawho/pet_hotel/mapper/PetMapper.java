package com.analuizawho.pet_hotel.mapper;

import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.entities.Pet;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(target = "id", ignore = true)
    DadosDetalhamentoPet petParaDetalhamento(Pet pet);

    @Mapping(target = "id", ignore = true)
    Pet cadastroParaPet(DadosCadastroPet dadosCadastroPet);

    @Mapping(target = "id", ignore = true)
    List<DadosListagemPet> petParaListagem(List<Pet> pet);
}

package com.analuizawho.pet_hotel.mapper;

import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    DadosDetalhamentoPet paraDetalhamento(Pet pet);

    Pet paraPet(DadosCadastroPet dadosCadastroPet);

    @Mapping(target = "id", ignore = true)
    List<DadosListagemPet> paraListagemDTO(List<Pet> pet);
}

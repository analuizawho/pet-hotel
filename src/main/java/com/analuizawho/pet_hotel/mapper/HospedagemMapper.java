package com.analuizawho.pet_hotel.mapper;

import com.analuizawho.pet_hotel.dto.DadosCheckInHospedagem;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoHospedagem;
import com.analuizawho.pet_hotel.dto.DadosListagemHospedagem;
import com.analuizawho.pet_hotel.entities.Hospedagem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospedagemMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(target = "pet", ignore = true)
    Hospedagem paraHospedagem(DadosCheckInHospedagem dto);

    @Mapping(target = "petId", source = "pet.id")
    DadosDetalhamentoHospedagem paraDetalhamento(Hospedagem hospedagem);

    @Mapping(target = "petId", source = "pet.id")
    DadosListagemHospedagem paraListagem(Hospedagem hospedagem);

    List<DadosListagemHospedagem> paraListagem(List<Hospedagem> hospedagem);
}

package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Animal;
import com.analuizawho.pet_hotel.entities.enums.Sexo;

public record DadosListagemPet(Long id,

                               String nome,

                               String raca,

                               Animal tipo,

                               float idade,

                               Sexo sexo) {
}

package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Animal;
import com.analuizawho.pet_hotel.entities.enums.Castracao;
import com.analuizawho.pet_hotel.entities.enums.Sexo;

public record DadosDetalhamentoPet(Long id,

                                   String nome,

                                   String raca,

                                   Animal tipo,

                                   float peso,

                                   float idade,

                                   String doenca,

                                   Castracao castracao,

                                   Sexo sexo
                                   ) {
}

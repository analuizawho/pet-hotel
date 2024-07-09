package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Animal;
import com.analuizawho.pet_hotel.entities.enums.Castracao;
import com.analuizawho.pet_hotel.entities.enums.Sexo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(
                               @NotBlank
                               String nome,

                               @NotNull
                               Animal tipo,

                               @NotBlank
                               String raca,

                               float peso,

                               float idade,

                               @NotBlank
                               String doenca,

                               @NotNull
                               Castracao castracao,

                               @NotNull
                               Sexo sexo) {
}

package com.analuizawho.pet_hotel.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPet(String nome,

                                float peso,

                                float idade,

                                String doenca) {
}

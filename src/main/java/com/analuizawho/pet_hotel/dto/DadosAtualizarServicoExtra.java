package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.ServicoExtra;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarServicoExtra(@NotNull
                                         ServicoExtra servicoExtra) {
}

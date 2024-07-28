package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Acomodacao;
import com.analuizawho.pet_hotel.entities.enums.ServicoExtra;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizarHospedagem(@NotNull Long petId,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                       LocalDateTime checkInData,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                       LocalDateTime checkOutData) {
}

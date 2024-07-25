package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Acomodacao;
import com.analuizawho.pet_hotel.entities.enums.ServicoExtra;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;


public record DadosCheckInHospedagem(@NotNull
                                     Long petId,
                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                     @NotNull
                                     LocalDateTime checkInData,
                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                     @NotNull
                                     LocalDateTime checkOutData,
                                     @NotNull
                                     Acomodacao acomodacao,
                                     @NotNull
                                     ServicoExtra servicoExtra) {
}

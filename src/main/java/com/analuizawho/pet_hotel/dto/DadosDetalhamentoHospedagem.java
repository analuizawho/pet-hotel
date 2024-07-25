package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.Hospedagem;
import com.analuizawho.pet_hotel.entities.Pet;
import com.analuizawho.pet_hotel.entities.enums.Acomodacao;
import com.analuizawho.pet_hotel.entities.enums.ServicoExtra;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoHospedagem(Long numeroHospedagem,
                                          Long petId,
                                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                          LocalDateTime checkInData,
                                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                          LocalDateTime checkOutData,
                                          Acomodacao acomodacao,
                                          ServicoExtra servicoExtra
                                          ) {
}

package com.analuizawho.pet_hotel.dto;

import com.analuizawho.pet_hotel.entities.enums.Acomodacao;
import com.analuizawho.pet_hotel.entities.enums.ServicoExtra;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record DadosDetalhamentoHospedagem(int numeroHospedagem,

                                          LocalDate checkInDate,

                                          LocalDate checkOutDate,

                                          Acomodacao acomodacao,

                                          ServicoExtra servicoExtra
                                          ) {
}

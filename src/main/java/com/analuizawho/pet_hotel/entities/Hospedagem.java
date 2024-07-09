package com.analuizawho.pet_hotel.entities;

import com.analuizawho.pet_hotel.entities.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;


public class Hospedagem extends Pet{

    int numeroHospedagem;
    LocalDate checkInDate = LocalDate.now();
    LocalDate checkOutDate;
    @Enumerated(EnumType.STRING)
    Acomodacao acomodacao;
    @Enumerated(EnumType.STRING)
    ServicoExtra servicoExtra;

    public Hospedagem() {
    }

    public Hospedagem(Castracao castracao, Boolean ativo, String doenca, float idade, String nome, float peso, String raca, Sexo sexo, Animal tipo, Acomodacao acomodacao, LocalDate checkInDate, LocalDate checkOutDate, int numeroHospedagem, ServicoExtra servicoExtra) {
        super(castracao, ativo, doenca, idade, nome, peso, raca, sexo, tipo);
        this.acomodacao = acomodacao;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numeroHospedagem = numeroHospedagem;
        this.servicoExtra = servicoExtra;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumeroHospedagem() {
        return numeroHospedagem;
    }

    public void setNumeroHospedagem(int numeroHospedagem) {
        this.numeroHospedagem = numeroHospedagem;
    }

    public ServicoExtra getServicoExtra() {
        return servicoExtra;
    }

    public void setServicoExtra(ServicoExtra servicoExtra) {
        this.servicoExtra = servicoExtra;
    }
}

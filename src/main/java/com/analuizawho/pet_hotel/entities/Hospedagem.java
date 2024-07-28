package com.analuizawho.pet_hotel.entities;

import com.analuizawho.pet_hotel.dto.DadosAtualizarHospedagem;
import com.analuizawho.pet_hotel.dto.DadosAtualizarServicoExtra;
import com.analuizawho.pet_hotel.entities.enums.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Entity
@Table(name = "hospedagem")
public class Hospedagem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroHospedagem;
    @Column(name = "check_in_data", nullable = false)
    private LocalDateTime checkInData;
    @Column(name = "check_out_data", nullable = false)
    private LocalDateTime checkOutData;
    @Enumerated(EnumType.STRING)
    private Acomodacao acomodacao;
    @Enumerated(EnumType.STRING)
    private ServicoExtra servicoExtra;

    @ManyToOne()
    @JoinColumn(name = "pet_id", nullable = false)
    Pet pet;

    public Hospedagem() {
    }

    public Hospedagem(Acomodacao acomodacao, LocalDateTime checkInData, LocalDateTime checkOutData, Long numeroHospedagem, ServicoExtra servicoExtra) {
        this.acomodacao = acomodacao;
        this.checkInData = checkInData;
        this.checkOutData = checkOutData;
        this.numeroHospedagem = numeroHospedagem;
        this.servicoExtra = servicoExtra;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public ServicoExtra getServicoExtra() {
        return servicoExtra;
    }

    public void setServicoExtra(ServicoExtra servicoExtra) {
        this.servicoExtra = servicoExtra;
    }

    public Long getNumeroHospedagem() {
        return numeroHospedagem;
    }

    public void setNumeroHospedagem(Long numeroHospedagem) {
        this.numeroHospedagem = numeroHospedagem;
    }

    public LocalDateTime getCheckInData() {
        return checkInData;
    }

    public void setCheckInData(LocalDateTime checkInData) {
        this.checkInData = checkInData;
    }

    public LocalDateTime getCheckOutData() {
        return checkOutData;
    }

    public void setCheckOutData(LocalDateTime checkOutData) {
        this.checkOutData = checkOutData;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Hospedagem{" +
                "acomodacao=" + acomodacao +
                ", numeroHospedagem=" + numeroHospedagem +
                ", checkInData=" + checkInData +
                ", checkOutData=" + checkOutData +
                ", servicoExtra=" + servicoExtra +
                ", pet=" + pet +
                '}';
    }

    public void atualizarInformacoes(@Valid DadosAtualizarHospedagem dados) {
        if(dados.checkInData() != null){
            this.checkInData = dados.checkInData();
        }

        if(dados.checkOutData() != null){
            this.checkOutData = dados.checkOutData();
        }
    }

    public void atualizarServicoExtra(@Valid DadosAtualizarServicoExtra dados) {
        if(dados.servicoExtra() != null){
            this.servicoExtra = dados.servicoExtra();
        }
    }
}

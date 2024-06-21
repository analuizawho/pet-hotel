package com.analuizawho.pet_hotel.entities;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.entities.enums.Animal;
import com.analuizawho.pet_hotel.entities.enums.Castracao;
import com.analuizawho.pet_hotel.entities.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.Objects;

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Animal tipo;
    private String raca;
    private float peso;
    private float idade;
    private String doenca;
    @Enumerated(EnumType.STRING)
    private Castracao castracao;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private Boolean ativo;

    public Pet() {
    }

    public Pet(Castracao castracao, Boolean ativo, String doenca, float idade, String nome, float peso, String raca, Sexo sexo, Animal tipo) {
        this.castracao = castracao;
        this.ativo = ativo;
        this.doenca = doenca;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.raca = raca;
        this.sexo = sexo;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getIdade() {
        return idade;
    }

    public void setIdade(float idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Animal getTipo() {
        return tipo;
    }

    public void setTipo(Animal tipo) {
        this.tipo = tipo;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public Castracao getCastracao() {
        return castracao;
    }

    public void setCastracao(Castracao castracao) {
        this.castracao = castracao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    public void atualizarInformacoes(@Valid DadosAtualizarPet dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.peso() != 0){
            this.peso = dados.peso();
        }

        if(dados.idade() != 0){
            this.idade = dados.idade();
        }

        if(dados.doenca() != null){
            this.doenca = dados.doenca();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar(){
        this.ativo = true;
    }
}

package com.analuizawho.pet_hotel.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
}

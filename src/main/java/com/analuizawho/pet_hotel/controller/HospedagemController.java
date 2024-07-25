package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.DadosCheckInHospedagem;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoHospedagem;
import com.analuizawho.pet_hotel.service.HospedagemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospedagem")
public class HospedagemController {

    @Autowired
    HospedagemService hospedagemService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoHospedagem> checkIn(@RequestBody @Valid DadosCheckInHospedagem dto){
        var hospedagem = hospedagemService.checkIn(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospedagem);
    }
}

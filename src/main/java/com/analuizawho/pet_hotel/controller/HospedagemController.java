package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.DadosCheckInHospedagem;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoHospedagem;
import com.analuizawho.pet_hotel.dto.DadosListagemHospedagem;
import com.analuizawho.pet_hotel.service.HospedagemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<DadosListagemHospedagem>> listar(){
        var hospedagem = hospedagemService.listar();
        return ResponseEntity.ok(hospedagem);
    }
}

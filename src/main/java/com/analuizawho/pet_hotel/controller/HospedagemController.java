package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.*;
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoHospedagem> atualizar(@PathVariable Long id,
                                                                 @RequestBody @Valid DadosAtualizarHospedagem dto){
        var hospedagem = hospedagemService.atualizar(id, dto);
        return ResponseEntity.ok(hospedagem);
    }

    @PutMapping("servico-extra/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoHospedagem> adicionarServicoExtra(@PathVariable Long id,
                                                                             @RequestBody @Valid DadosAtualizarServicoExtra dto){
        var hospedagem = hospedagemService.adicionarServicoExtra(id, dto);
        return ResponseEntity.ok(hospedagem);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        hospedagemService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}

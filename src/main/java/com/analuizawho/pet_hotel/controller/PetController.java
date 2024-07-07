package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.exception.NumeroEmStringException;
import com.analuizawho.pet_hotel.service.PetService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPet> cadastrar(@RequestBody @Valid DadosCadastroPet dto,
                                                          UriComponentsBuilder uriBuilder){
        var pet = this.petService.cadastrar(dto, uriBuilder);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPet>> listar(){
        var lista = this.petService.listar();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoPet> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarPet dto){
        var pet = this.petService.atualizar(id, dto);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        petService.reativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPet> detalhar(@PathVariable Long id){
        var pet = petService.detalhar(id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id ){
        petService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        petService.inativar(id);
        return ResponseEntity.noContent().build();
    }

}

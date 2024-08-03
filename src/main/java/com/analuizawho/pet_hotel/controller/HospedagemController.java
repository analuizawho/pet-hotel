package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.*;
import com.analuizawho.pet_hotel.service.HospedagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedagem")
@Tag(name = "Hospedagem", description = "Endpoint para o gerenciamento de hospedagens")
public class HospedagemController {

    @Autowired
    HospedagemService hospedagemService;

    @PostMapping
    @Transactional
    @Operation(summary = "CheckIn de um pet", description = "Endpoint para fazer a hospedagem de um pet",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DadosListagemPet.class)
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<DadosDetalhamentoHospedagem> checkIn(@RequestBody @Valid DadosCheckInHospedagem dto){
        var hospedagem = hospedagemService.checkIn(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospedagem);
    }

    @GetMapping
    @Operation(summary = "Lista todas as hospedagens", description = "Endpoint para listar todas as hospedagens e id" +
            "dos hóspedes",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = DadosListagemPet.class)
                                            ))
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<DadosListagemHospedagem>> listar(){
        var hospedagem = hospedagemService.listar();
        return ResponseEntity.ok(hospedagem);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalha uma hospedagem", description = "Endpoint para encontrar informações de uma hospedagem",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DadosListagemPet.class)
                                    )
                            }),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<DadosDetalhamentoHospedagem> detalhar(@PathVariable Long id){
        var hospedagem = hospedagemService.detalhar(id);
        return ResponseEntity.ok(hospedagem);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualiza uma hospedagem", description = "Endpoint para atualizar informações de uma hospedagem",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DadosListagemPet.class)
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<DadosDetalhamentoHospedagem> atualizar(@PathVariable Long id,
                                                                 @RequestBody @Valid DadosAtualizarHospedagem dto){
        var hospedagem = hospedagemService.atualizar(id, dto);
        return ResponseEntity.ok(hospedagem);
    }

    @PutMapping("servico-extra/{id}")
    @Transactional
    @Operation(summary = "Adicionar serviço extra", description = "Endpoint para adicionar um serviço extra na hospedagem",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DadosListagemPet.class)
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<DadosDetalhamentoHospedagem> adicionarServicoExtra(@PathVariable Long id,
                                                                             @RequestBody @Valid DadosAtualizarServicoExtra dto){
        var hospedagem = hospedagemService.adicionarServicoExtra(id, dto);
        return ResponseEntity.ok(hospedagem);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Excluir uma hospedagem", description = "Endpoint para excluir uma hospedagem",
            tags = {"Hospedagem"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        hospedagemService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}

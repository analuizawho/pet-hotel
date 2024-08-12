package com.analuizawho.pet_hotel.controller;

import com.analuizawho.pet_hotel.dto.DadosAtualizarPet;
import com.analuizawho.pet_hotel.dto.DadosCadastroPet;
import com.analuizawho.pet_hotel.dto.DadosDetalhamentoPet;
import com.analuizawho.pet_hotel.dto.DadosListagemPet;
import com.analuizawho.pet_hotel.service.PetService;
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
@RequestMapping("pet-hotel/pet")
@Tag(name = "Pet", description = "Endpoint para o gerenciamento de pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra um pet", description = "Endpoint para fazer o cadastro de um pet",
            tags = {"Pet"},
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
    public ResponseEntity<DadosDetalhamentoPet> cadastrar(@RequestBody @Valid DadosCadastroPet dto){
        var pet = this.petService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @GetMapping
    @Operation(summary = "Lista todos os pets", description = "Endpoint para listar todos os pets",
            tags = {"Pet"},
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
    public ResponseEntity<List<DadosListagemPet>> listar(){
        var lista = this.petService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalha um pet", description = "Endpoint para encontrar informações de um pet",
            tags = {"Pet"},
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
    public ResponseEntity<DadosDetalhamentoPet> detalhar(@PathVariable Long id){
        var pet = petService.detalhar(id);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualiza um pet", description = "Endpoint para atualizar informações de um pet",
            tags = {"Pet"},
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
    public ResponseEntity<DadosDetalhamentoPet> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarPet dto){
        var pet = this.petService.atualizar(id, dto);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("reativar/{id}")
    @Transactional
    @Operation(summary = "Reativa um pet", description = "Endpoint para reativar um pet",
            tags = {"Pet"},
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
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        petService.reativar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    @Operation(summary = "Inativa um pet", description = "Endpoint para inativar um pet",
            tags = {"Pet"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> inativar(@PathVariable Long id){
        petService.inativar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Excluir um pet", description = "Endpoint para excluir um pet ",
            tags = {"Pet"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id ){
        petService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}

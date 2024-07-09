package com.analuizawho.pet_hotel.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
public class TratadorDeErros {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(NumeroEmStringException.class)
    ResponseEntity<DadosDoErro> tratadorNumeroEmString(NumeroEmStringException exception){
        Date data = new Date();
        String dataFormatada = sdf.format(data);
        DadosDoErro dadosDoErro = new DadosDoErro(dataFormatada, exception.getMessage(), exception.getCampo());
        return ResponseEntity.badRequest().body(dadosDoErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosDoErro::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404(){
        return ResponseEntity.notFound().build();
    }


}

package com.analuizawho.pet_hotel.exception;

import org.springframework.validation.FieldError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosDoErro {

    String mensagem;
    String campo;
    String dataDoErro;

    public DadosDoErro() {
    }

    public DadosDoErro(String dataDoErro, String mensagem, String campo) {
        this.dataDoErro = dataDoErro;
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public DadosDoErro(FieldError fieldError) {
    }

    public String getDataDoErro() {
        return dataDoErro;
    }

    public void setDataDoErro(String dataDoErro) {
        this.dataDoErro = dataDoErro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

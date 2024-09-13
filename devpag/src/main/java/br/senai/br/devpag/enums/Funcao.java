package br.senai.br.devpag.enums;

public enum Funcao {

    PORTARIA("Portaria"),
    ADMINISTRADOR("Administração");

    private String descricao;

    Funcao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}

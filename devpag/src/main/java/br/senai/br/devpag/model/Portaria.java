package br.senai.br.devpag.model;

import br.senai.br.devpag.enums.Funcao;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//determina que P = Portaria no tipo de pessoa
@DiscriminatorValue(value = "P")
public class Portaria extends Pessoa {

    //tipo de funcao do funcionario
    private Funcao funcao;

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
}

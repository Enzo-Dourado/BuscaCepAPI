package br.com.projeto.buscaapi.apiviacep.modelos;

import br.com.projeto.buscaapi.apiviacep.record.ApiRefatorada;

public class Cep {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String estado;
    private String uf;

    public Cep(String cep) {
        this.cep = cep;
    }

    public Cep(ApiRefatorada cep) {
        this.cep = cep.cep();
        this.logradouro = cep.logradouro();
        this.bairro = cep.bairro();
        this.localidade = cep.localidade();
        this.estado = cep.estado();
        this.uf = cep.uf();
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "\nCep {cep = " + cep +
                ",\nlogradouro = " + logradouro +
                ",\nbairro = " + bairro +
                ",\nlocalidade = " + localidade +
                ",\nestado = " + estado +
                ",\nuf = " + uf +"}\n";
    }
}

package br.com.projeto.buscaapi.apiviacep.record;

public record ApiRefatorada(
    String logradouro,
    String bairro,
    String localidade,
    String estado,
    String uf
) {
}

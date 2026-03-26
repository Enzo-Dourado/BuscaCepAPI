package br.com.projeto.buscaapi.apiviacep.record;

public record ApiRefatorada(
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String estado,
    String uf
) {
}

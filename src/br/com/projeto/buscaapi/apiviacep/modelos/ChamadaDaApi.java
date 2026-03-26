package br.com.projeto.buscaapi.apiviacep.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChamadaDaApi extends Cep{
    private String url;
    private String json;

    public String getJson() {
        return json;
    }

    public ChamadaDaApi(String cep) {
        super(cep);
    }

    public String getUrl() {
        url = "https://viacep.com.br/ws/" + String.valueOf(getCep()) + "/json/";
        return url;
    }


    public void setJson(String json) {
        this.json = json;
    }

    public void chamaApi() {
        try {
            // Base para todas as chamadas de APIs
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(getUrl()))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            setJson(response.body());



        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Erro capturado: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Valores estão recebendo como null como valor");

        } catch (IllegalArgumentException e) {
            System.out.println("API precisa de um protocolo para retornar, re-veja!");;
        }

    }

    public boolean encontraCep() {
       return json != null
               && !json.isBlank()
               && !json.contains("\"erro\" : true");
    }
}

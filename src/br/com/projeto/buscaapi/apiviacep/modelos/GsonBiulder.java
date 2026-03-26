package br.com.projeto.buscaapi.apiviacep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonBiulder {
    private Gson gson;

    public Gson getGson() {
        return gson;
    }

    public void chamaGson() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}

package br.com.projeto.buscaapi.apiviacep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GsonBiulder {
    private Gson gson;
    private FileWriter fw;

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public Gson getGson() {
        return gson;
    }

    public FileWriter getFw() {
        return fw;
    }

    public void setFw(FileWriter fw) {
        this.fw = fw;
    }


    public void chamaGson() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void criaArquivo(List<Cep> cep) {
        try{
            setFw(new FileWriter("Cep.json"));
            getFw().write(getGson().toJson(cep));
            getFw().close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

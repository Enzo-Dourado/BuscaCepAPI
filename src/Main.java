import br.com.projeto.buscaapi.apiviacep.modelos.Cep;
import br.com.projeto.buscaapi.apiviacep.modelos.ChamadaDaApi;
import br.com.projeto.buscaapi.apiviacep.modelos.GsonBiulder;
import br.com.projeto.buscaapi.apiviacep.record.ApiRefatorada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chamadaCep;
        List<Cep> listaCep = new ArrayList<>();

        while (true) {

            System.out.print("Digite o CEP que você deseja buscar informações ('sair' para finalizar): ");
            chamadaCep = sc.next();

             if (chamadaCep.equalsIgnoreCase("sair")) {
                 System.out.println("Fim do programa");
                 break;

             } else if (chamadaCep.length() == 8 && chamadaCep.charAt(0) == '0') {

                ChamadaDaApi chamarApi = new ChamadaDaApi(chamadaCep);
                chamarApi.getUrl();
                chamarApi.chamaApi();

                if (!chamarApi.encontraCep()) {
                    System.out.println("Valores não encontrados para o CEP informado.");
                    continue;
                }

                GsonBiulder gson =  new GsonBiulder();
                gson.chamaGson();
                ApiRefatorada cepInfos = gson.getGson().fromJson(chamarApi.getJson(), ApiRefatorada.class);

                if (cepInfos == null || cepInfos.cep() == null) {
                    System.out.println("Valores não encontrados para o CEP informado: " + chamadaCep);
                } else {
                    Cep cep = new Cep(cepInfos);
                    listaCep.add(cep);
                }

            } else {
                System.out.println("Cep digitado inválido, ou não é do Estado de São Paulo... tente novamente.");

            }
        }

        for (Cep ceps : listaCep) {
            System.out.println(ceps);
        }
    }
}

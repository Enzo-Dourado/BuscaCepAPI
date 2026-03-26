import br.com.projeto.buscaapi.apiviacep.modelos.Cep;
import br.com.projeto.buscaapi.apiviacep.modelos.ChamadaDaApi;
import br.com.projeto.buscaapi.apiviacep.modelos.GsonBiulder;
import br.com.projeto.buscaapi.apiviacep.record.ApiRefatorada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CEP que você deseja buscar informações: ");
        ChamadaDaApi chamarApi = new ChamadaDaApi(sc.next());

        chamarApi.getUrl();
        chamarApi.chamaApi();

        GsonBiulder gson =  new GsonBiulder();
        gson.chamaGson();
        ApiRefatorada cepInfos = gson.getGson().fromJson(chamarApi.getJson(), ApiRefatorada.class);
        Cep cep = new Cep(cepInfos);
        System.out.println(cep);

    }
}

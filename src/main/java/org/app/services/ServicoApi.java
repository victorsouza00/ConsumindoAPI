package org.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.Dto.DtoEndereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoApi{

    DtoEndereco dtoEndereco = new DtoEndereco();
    public DtoEndereco getEndereco(String CEP) throws IOException,InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/"+CEP+"/json/")).build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());


            //Mapeando no objeto Dto
            ObjectMapper mapper = new ObjectMapper();
            this.dtoEndereco = mapper.readValue(response.body(),DtoEndereco.class);
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        return this.dtoEndereco;
    }
}

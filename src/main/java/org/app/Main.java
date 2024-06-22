package org.app;

import org.app.Dto.DtoEndereco;
import org.app.services.ServicoApi;

public class Main {
    public static void main(String[] args) {

        ServicoApi servicoApi = new ServicoApi();


        try {
            System.out.println(servicoApi.getEndereco("54735080"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }





}
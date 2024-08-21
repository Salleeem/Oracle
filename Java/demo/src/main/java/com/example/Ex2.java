package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Ex2 {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/users"; 

        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            con.disconnect();

            JSONArray jsonArray = new JSONArray(content.toString());
            int totalUsuarios = jsonArray.length();
            double somaIdades = 0;

            System.out.println("Usuários:");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String nome = obj.getString("name");
                int idade = obj.getInt("age"); 
                String cidade = obj.getJSONObject("address").getString("city");

                System.out.println("Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade);
                somaIdades += idade;
            }

            double mediaIdade = somaIdades / totalUsuarios;
            System.out.println("Número total de usuários: " + totalUsuarios);
            System.out.println("Média de idade dos usuários: " + mediaIdade);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

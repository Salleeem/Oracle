package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex3 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "postgres";

        try {
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

            double somaPrecos = 0;
            int contador = 0;
            double maiorPreco = Double.MIN_VALUE;
            double menorPreco = Double.MAX_VALUE;
            String produtoMaisCaro = "";
            String produtoMaisBarato = "";

            System.out.println("Produtos:");
            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                System.out.println("Nome: " + nome + ", Preço: R$ " + preco);

                somaPrecos += preco;
                contador++;

                if (preco > maiorPreco) {
                    maiorPreco = preco;
                    produtoMaisCaro = nome;
                }
                if (preco < menorPreco) {
                    menorPreco = preco;
                    produtoMaisBarato = nome;
                }
            }

            double mediaPreco = somaPrecos / contador;
            System.out.println("Produto mais caro: " + produtoMaisCaro + " com preço R$ " + maiorPreco);
            System.out.println("Produto mais barato: " + produtoMaisBarato + " com preço R$ " + menorPreco);
            System.out.println("Média de preços dos produtos: R$ " + mediaPreco);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

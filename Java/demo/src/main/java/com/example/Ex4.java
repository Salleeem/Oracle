package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) {
        String inputCSV = "produtos.csv";
        String outputCSV = "produtos_com_valor.csv";
        String linha;
        double maiorValorTotal = Double.MIN_VALUE;
        String produtoMaisValioso = "";

        try (BufferedReader br = new BufferedReader(new FileReader(inputCSV));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputCSV))) {

            String header = "nome,quantidade,preco,valor_total";
            bw.write(header);
            bw.newLine();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                int quantidade = Integer.parseInt(partes[1]);
                double preco = Double.parseDouble(partes[2]);
                double valorTotal = quantidade * preco;

                if (valorTotal > maiorValorTotal) {
                    maiorValorTotal = valorTotal;
                    produtoMaisValioso = nome;
                }

                bw.write(nome + "," + quantidade + "," + preco + "," + valorTotal);
                bw.newLine();
            }

            System.out.println("Produto com o maior valor total em estoque: " + produtoMaisValioso + " com valor R$ " + maiorValorTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

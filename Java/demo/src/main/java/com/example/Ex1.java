package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        String arquivo = "alunos.txt"; 
        String linha;
        double totalNotas = 0;
        int contador = 0;
        double maiorNota = Double.MIN_VALUE;
        double menorNota = Double.MAX_VALUE;
        String alunoMaiorNota = "";
        String alunoMenorNota = "";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                double nota1 = Double.parseDouble(partes[1]);
                double nota2 = Double.parseDouble(partes[2]);
                double nota3 = Double.parseDouble(partes[3]);
                double media = (nota1 + nota2 + nota3) / 3;

                totalNotas += media;
                contador++;

                if (media > maiorNota) {
                    maiorNota = media;
                    alunoMaiorNota = nome;
                }
                if (media < menorNota) {
                    menorNota = media;
                    alunoMenorNota = nome;
                }
            }

            double mediaGeral = totalNotas / contador;
            System.out.println("Aluno com a maior nota: " + alunoMaiorNota + " com nota " + maiorNota);
            System.out.println("Aluno com a menor nota: " + alunoMenorNota + " com nota " + menorNota);
            System.out.println("Média geral da turma: " + mediaGeral);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

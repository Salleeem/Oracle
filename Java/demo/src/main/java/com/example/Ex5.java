package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex5 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "postgres";

        try {
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = con.createStatement();

            // Exibir todos os clientes
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
            System.out.println("Clientes:");
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("Nome: " + nome + ", Email: " + email);
            }

            // Adicionar um novo cliente
            stmt.executeUpdate("INSERT INTO clientes (nome, email) VALUES ('Novo Cliente', 'novo@cliente.com')");

            // Atualizar e-mail de um cliente
            stmt.executeUpdate("UPDATE clientes SET email = 'atualizado@cliente.com' WHERE id = 1");

            // Excluir um cliente
            stmt.executeUpdate("DELETE FROM clientes WHERE id = 2");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

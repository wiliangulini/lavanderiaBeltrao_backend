/*
package com.marina.springlavanderia.service;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DeserializarValorFinal {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/lavanderia_teste2";
        String user = "root";
        String password = "#Naotemsenha23#";

        Connection conn = DriverManager.getConnection(url, user, password);

        // Crie a nova coluna se ainda não tiver feito
        //conn.createStatement().executeUpdate("ALTER TABLE pedidos ADD COLUMN valorFinal_tmp DOUBLE");

        PreparedStatement psSelect = conn.prepareStatement("SELECT id, valor_final FROM pedidos");
        ResultSet rs = psSelect.executeQuery();

        PreparedStatement psUpdate = conn.prepareStatement("UPDATE pedidos SET valor_final_tmp = ? WHERE id = ?");

        while (rs.next()) {
            long id = rs.getLong("id");
            byte[] data = rs.getBytes("valor_final");
            if (data == null) continue;

            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                Object obj = ois.readObject();
                if (obj instanceof Number) {
                    double valor = ((Number) obj).doubleValue();
                    psUpdate.setDouble(1, valor);
                    psUpdate.setLong(2, id);
                    psUpdate.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println("Erro ao desserializar id=" + id + ": " + e.getMessage());
            }
        }

        conn.close();
    }
}

 */
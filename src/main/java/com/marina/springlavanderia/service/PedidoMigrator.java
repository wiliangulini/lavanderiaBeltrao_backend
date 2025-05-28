package com.marina.springlavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class PedidoMigrator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final int TOTAL_VARIACOES = 6;

    public void migrarTodos() {
        for (int i = 1; i <= TOTAL_VARIACOES; i++) {
            migrarGrupo(i);
        }
    }

    private Integer parseToInteger(Object value) {
        if (value == null) return null;

        if (value instanceof Integer) {
            return (Integer) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue();
        }

        if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                System.err.println("❌ Número inválido: " + value);
            }
        }

        return null;
    }

    private Boolean parseToBoolean(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean) return (Boolean) value;
        if (value instanceof String) return Boolean.parseBoolean((String) value);
        return false;
    }


    private void migrarGrupo(int grupo) {
        System.out.println("Iniciando migração do grupo: " + grupo);

        String sufixo = (grupo == 1) ? "" : String.valueOf(grupo - 1);

        String sql = String.format(
                "SELECT id, quantidade%s AS quantidade, descricao%s AS descricao, total%s AS total, retirada%s AS retirada " +
                        "FROM pedidos WHERE quantidade%s IS NOT NULL OR descricao%s IS NOT NULL OR total%s IS NOT NULL OR retirada%s IS NOT NULL",
                sufixo, sufixo, sufixo, sufixo, sufixo, sufixo, sufixo, sufixo
        );

        List<Map<String, Object>> registros = jdbcTemplate.queryForList(sql);

        int inseridos = 0;
        for (Map<String, Object> row : registros) {
            try {
                Long pedidoId = ((Number) row.get("id")).longValue();
                Integer quantidade = parseToInteger(row.get("quantidade"));
                String descricao = (String) row.get("descricao");
                Object totalRaw = row.get("total");

                if (totalRaw == null) {
                    System.out.printf("⚠️  Ignorado: total nulo (grupo %d, pedido ID %d)%n", grupo, pedidoId);
                    continue;
                }

                BigDecimal totalDesserializado = desserializarTotal(totalRaw);
                if (totalDesserializado == null) {
                    System.err.printf("❌ Total inválido (grupo %d, pedido ID %d)%n", grupo, pedidoId);
                    continue;
                }

                Boolean retirada = parseToBoolean(row.get("retirada"));

                jdbcTemplate.update(
                        "INSERT INTO pedido_itens (pedido_id, quantidade, descricao, total, retirada) VALUES (?, ?, ?, ?, ?)",
                        pedidoId, quantidade, descricao, totalDesserializado, retirada
                );
                inseridos++;

            } catch (Exception e) {
                System.err.printf("❌ Erro ao processar grupo %d: %s%n", grupo, e.getMessage());
            }
        }

        System.out.printf("✅ Migração do grupo %d concluída. Registros inseridos: %d%n%n", grupo, inseridos);
    }


    private BigDecimal desserializarTotal(Object totalRaw) {
        try {
            byte[] data;

            if (totalRaw instanceof byte[]) {
                data = (byte[]) totalRaw;
            } else if (totalRaw instanceof String) {
                // Caso esteja salvo como VARCHAR com serialização binária convertida em texto
                data = ((String) totalRaw).getBytes(StandardCharsets.ISO_8859_1);
            } else {
                return null;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                Object obj = ois.readObject();

                if (obj instanceof Number) {
                    return new BigDecimal(obj.toString());
                }
            }

        } catch (Exception e) {
            // Ignorar erro específico de desserialização
        }

        return null;
    }
}


package com.marina.springlavanderia.runner;

import com.marina.springlavanderia.service.PedidoMigrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MigracaoRunner implements CommandLineRunner {

    @Autowired
    private PedidoMigrator pedidoMigrator;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pedido_itens", Long.class);
        if (count == 0) {
            System.out.println("🚀 Iniciando migração de pedidos...");
            pedidoMigrator.migrarTodos();
            System.out.println("✅ Migração concluída.");
        } else {
            System.out.println("⏩ Migração ignorada: tabela pedido_itens já possui dados.");
        }
    }
}

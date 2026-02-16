package com.tu.portfolio.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        if (isMySQLAvailable()) {
            configurarMySQL();
            return crearDataSourceMySQL();
        } else {
            configurarH2();
            return crearDataSourceH2();
        }
    }

    private void configurarMySQL() {
        System.out.println("=====================================");
        System.out.println("  MySQL DETECTADO");
        System.out.println("  Base de datos: portfolio");
        System.out.println("  Archivo SQL: data.sql");
        System.out.println("  URL: http://localhost:8080");
        System.out.println("=====================================");

        // Configurar propiedades para MySQL
        System.setProperty("spring.sql.init.data-locations", "classpath:data.sql");
        System.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    }

    private void configurarH2() {
        System.out.println("=====================================");
        System.out.println("  MySQL NO DISPONIBLE");
        System.out.println("  Usando H2 en memoria como fallback");
        System.out.println("  Archivo SQL: databaseH2.sql");
        System.out.println("=====================================");
        System.out.println("  URL aplicación: http://localhost:8080");
        System.out.println("  Consola H2: http://localhost:8080/h2-console");
        System.out.println("  JDBC URL: jdbc:h2:mem:portfolio");
        System.out.println("  Username: sa");
        System.out.println("  Password: (dejar vacío)");
        System.out.println("=====================================");

        // Configurar propiedades para H2
        System.setProperty("spring.sql.init.data-locations", "classpath:databaseH2.sql");
        System.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        System.setProperty("spring.jpa.defer-datasource-initialization", "true");
    }

    private DataSource crearDataSourceMySQL() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/portfolio?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&characterEncoding=UTF-8")
                .username("root")
                .password("")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    private DataSource crearDataSourceH2() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:portfolio")
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver")
                .build();
    }

    /**
     * Verifica si MySQL está disponible y accesible
     */
    private boolean isMySQLAvailable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/portfolio?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root",
                    "")) {
                return connection != null && !connection.isClosed();
            }
        } catch (Exception e) {
            return false;
        }
    }
}
package com.gabrielssantana.certification_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
  private final JdbcTemplate jdbcTemplate;

  public CreateSeed(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public static void main(String[] args) {
    var dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres_nlw");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");

    var createSeed = new CreateSeed(dataSource);
    createSeed.run(args);
  }

  public void run(String... args) {
    executeSqlFile("src/main/resources/create.sql");
  }

  private void executeSqlFile(String filePath) {
    try {
      var sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
      jdbcTemplate.execute(sqlScript);
      System.out.println("Seed executado com sucesso");
    } catch (IOException e) {
      System.err.println(String.format("Erro ao executar o arquivo: %s", filePath));
    }
  }
}

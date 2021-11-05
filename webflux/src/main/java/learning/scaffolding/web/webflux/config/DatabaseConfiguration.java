package learning.scaffolding.web.webflux.config;

import io.r2dbc.spi.ConnectionFactory;
import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {

  @Override
  @Bean
  public ConnectionFactory connectionFactory() {
    return MariadbConnectionFactory.from(
        MariadbConnectionConfiguration.builder()
            .username("user")
            .password("password")
            .database("db")
            .host("localhost")
            .port(3306)
            .build());
  }

  @Bean
  public ReactiveTransactionManager reactiveTransactionManager(
      ConnectionFactory connectionFactory) {
    return new R2dbcTransactionManager(connectionFactory);
  }
}

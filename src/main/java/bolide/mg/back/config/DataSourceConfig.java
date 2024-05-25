package bolide.mg.back.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
  @Bean
  public DataSource getDataSource() {
    String url = System.getenv("DB_URL");
    String userName = System.getenv("DB_USERNAME");
    String password = System.getenv("DB_PASSWORD");
    return DataSourceBuilder.create().url(url).username(userName).password(password).build();
  }
}

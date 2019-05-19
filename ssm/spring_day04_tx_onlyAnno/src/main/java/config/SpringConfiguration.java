package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("cn.itcast")
@Import({JdbcConfig.class,TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfiguration {
}

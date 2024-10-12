package lk.ijse.sprinpos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Naveen Theekshana
 * @date 10/11/2024
 * @project SpringPos
 */

@Configuration
@ComponentScan(basePackages = "lk.ijse.sprinpos")
@EnableJpaRepositories(basePackages = "lk.ijse.sprinpos")
@EnableWebMvc
public class WebAppConfig {
}

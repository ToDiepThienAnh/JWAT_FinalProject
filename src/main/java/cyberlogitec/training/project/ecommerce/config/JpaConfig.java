package cyberlogitec.training.project.ecommerce.config;

import cyberlogitec.training.project.ecommerce.common.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImpl();
    }


}

package cyberlogitec.training.project.ecommerce.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            String userCurrent = SecurityContextHolder.getContext().getAuthentication().getName();
            return Optional.ofNullable(userCurrent);
        } catch (NullPointerException e){
            e.printStackTrace();
        } finally {
            return Optional.ofNullable("customer register");
        }
    }
}

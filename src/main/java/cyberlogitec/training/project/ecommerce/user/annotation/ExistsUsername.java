package cyberlogitec.training.project.ecommerce.user.annotation;

import cyberlogitec.training.project.ecommerce.user.validation.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsUsername {
    String message() default "Username is exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

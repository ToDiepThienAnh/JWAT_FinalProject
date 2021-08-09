package cyberlogitec.training.project.ecommerce.user.annotation;

import cyberlogitec.training.project.ecommerce.user.validation.CheckNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNumber {
    String message() default "Phone is wrong format";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

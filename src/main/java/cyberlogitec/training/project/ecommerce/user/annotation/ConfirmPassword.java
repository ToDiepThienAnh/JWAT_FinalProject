package cyberlogitec.training.project.ecommerce.user.annotation;

import cyberlogitec.training.project.ecommerce.user.validation.ConfirmPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPassword {
    String message() default "Password is not the same with confirmPassword";

    String getPassword() default "getPassword";

    String getConfirmPassword() default "getConfirmPassword";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

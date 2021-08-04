package cyberlogitec.training.project.ecommerce.user.validation;

import cyberlogitec.training.project.ecommerce.user.annotation.ExistsEmail;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<ExistsEmail, String> {
    @Autowired
    private UserService userService;

    private String message;

    @Override
    public void initialize(ExistsEmail constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isEmailExists = userService.isEmailTaken(value);
        if(!isEmailExists)
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

package cyberlogitec.training.project.ecommerce.user.validation;

import cyberlogitec.training.project.ecommerce.user.annotation.ExistsUsername;
import cyberlogitec.training.project.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<ExistsUsername, String> {
    @Autowired
    private UserService userService;

    private String message;

    @Override
    public void initialize(ExistsUsername constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isUsernameExists = userService.isUsernameTaken(value);
        if(!isUsernameExists)
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

package cyberlogitec.training.project.ecommerce.user.validation;

import cyberlogitec.training.project.ecommerce.user.annotation.CheckNumber;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckNumberValidator implements ConstraintValidator<CheckNumber, String> {
    private String message;

    @Override
    public void initialize(CheckNumber constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtils.isNumeric(value))
            return false;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return true;
    }
}

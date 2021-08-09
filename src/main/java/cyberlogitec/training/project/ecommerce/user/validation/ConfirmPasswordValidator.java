package cyberlogitec.training.project.ecommerce.user.validation;

import cyberlogitec.training.project.ecommerce.user.annotation.ConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, Object> {
    private String getPassword;
    private String message;
    private String getConfirmPassword;

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {
        this.getPassword = constraintAnnotation.getPassword();
        this.message = constraintAnnotation.message();
        this.getConfirmPassword = constraintAnnotation.getConfirmPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            String password = (String) value.getClass().getMethod(getPassword).invoke(value);
            String confirmPassword = (String) value.getClass().getMethod(getConfirmPassword).invoke(value);
            if(password.equals(confirmPassword))
                return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

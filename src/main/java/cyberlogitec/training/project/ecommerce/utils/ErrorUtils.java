package cyberlogitec.training.project.ecommerce.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.LinkedList;
import java.util.List;

public class ErrorUtils {
    public static List<String> getErrorMessages(BindingResult bindingResult){
        List<String> list = new LinkedList<>();
        List<ObjectError> errors = bindingResult.getAllErrors();

        for (ObjectError error : errors){
            list.add(error.getDefaultMessage());
        }
        return list;
    }

    public static List<String> getErrorMessages(String error){
        List<String> list = new LinkedList<>();
        list.add(error);
        return list;
    }
}

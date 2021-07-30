package cyberlogitec.training.project.ecommerce.common;

import cyberlogitec.training.project.ecommerce.utils.ErrorUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponseObject {
    private static List<String> emptyString = new LinkedList<>();
    private static Map<String, Object> map = new HashMap<>();
    public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
        map.put("content", content);
        map.put("errors", emptyString);
        map.put("status", status.value());
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> getResponse(BindingResult bindingResult, HttpStatus status){
        map.put("content", emptyString);
        map.put("errors", ErrorUtils.getErrorMessages(bindingResult));
        map.put("status", status.value());
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> getResponse(String error, HttpStatus status){
        map.put("content", emptyString);
        map.put("errors", error);
        map.put("status", status.value());
        return new ResponseEntity<>(map, status);
    }
}

package icu.azusachino.apricot.support.handler;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * exception handler for rest requests
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * default handler for exception
     * 
     * @param e ex
     * @return 500 response
     */
    @ExceptionHandler(Exception.class)
    ResponseEntity<Map<String, ?>> exceptionHandler(Exception e) {
        return ResponseEntity.internalServerError().body(Map.of("msg", e.getLocalizedMessage()));
    }
}

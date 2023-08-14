package esy.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RestController
public class EsyDemoClientControllerAdvice extends ResponseEntityExceptionHandler implements ErrorController {

    @ExceptionHandler
    public ResponseEntity<Object> handleException(final WebRequest request, final Exception cause) {
        final var error = new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, cause.getMessage(), cause);
        return handleErrorResponseException(error, error.getHeaders(), error.getStatusCode(), request);
    }

    @RequestMapping("${server.error.path:/error}")
    public ResponseEntity<Object> error(final WebRequest request) {
        final var error = new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        return handleErrorResponseException(error, error.getHeaders(), error.getStatusCode(), request);
    }

    @Override
    protected ResponseEntity<Object> createResponseEntity(Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return ResponseEntity
                .status(statusCode)
                .headers(headers)
                .cacheControl(CacheControl.noStore())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}

package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int httpStatus;
    private String message;
    private String stacktrace;
}
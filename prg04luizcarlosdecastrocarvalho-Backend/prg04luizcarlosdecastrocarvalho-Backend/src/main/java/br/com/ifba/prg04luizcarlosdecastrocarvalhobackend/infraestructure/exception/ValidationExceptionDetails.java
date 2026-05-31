package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.exception;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class ValidationExceptionDetails {
    private String title;
    private int status;
    private String details;
    private LocalDateTime timestamp;
    private String developerMessage;
    private String fields;
    private String fieldsMessage;
}

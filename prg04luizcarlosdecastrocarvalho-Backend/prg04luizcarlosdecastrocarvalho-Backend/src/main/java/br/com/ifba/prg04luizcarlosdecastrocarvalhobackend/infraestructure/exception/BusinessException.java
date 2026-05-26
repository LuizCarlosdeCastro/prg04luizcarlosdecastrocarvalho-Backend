package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.infraestructure.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public BusinessException(){
        super();
    }

    public BusinessException(final String mensagem) {
        super(mensagem);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    public BusinessException(final String mensagem, final Throwable cause) {
        super(mensagem, cause);
    }


}

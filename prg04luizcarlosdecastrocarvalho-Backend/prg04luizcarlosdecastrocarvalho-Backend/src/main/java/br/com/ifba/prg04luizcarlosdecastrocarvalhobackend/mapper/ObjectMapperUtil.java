package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper;

import org.xmlunit.builder.Input;
import tools.jackson.databind.ObjectMapper;
import java.lang.module.Configuration;

public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ObjectMapper();
    }
    public <input, Output> Output map(final Input object,
                                      final Class<Output> class){
        MODEL_MAPPER.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAcessLevel(Configuration.AcessLevel.PRIVATE);

        Output c = MODEL_MAPPER.map(object, class);

        return c;
    }
}

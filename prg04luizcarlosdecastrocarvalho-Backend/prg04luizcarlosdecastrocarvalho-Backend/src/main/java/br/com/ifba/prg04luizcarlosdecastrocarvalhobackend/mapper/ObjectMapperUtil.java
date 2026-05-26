package br.com.ifba.prg04luizcarlosdecastrocarvalhobackend.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
    }
    public static <Input, Output> Output map(final Input object, final Class<Output> clazz){
        MODEL_MAPPER.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return MODEL_MAPPER.map(object, clazz);
    }

    public static <Input, Output> List<Output> mapList(final List<Input> inputList, final Class<Output> clazz) {
        return inputList.stream()
                .map(element -> map(element, clazz))
                .collect(Collectors.toList());
    }
}

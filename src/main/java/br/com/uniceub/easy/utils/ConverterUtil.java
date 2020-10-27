package br.com.uniceub.easy.utils;

import br.com.uniceub.easy.exception.EasyException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ConverterUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterUtil.class);

    private static final ModelMapper MAPPER = new ModelMapper();

    public static <T> T converterToDTO(Object source, Class<T> target, String ... ignoreProperties) {
        try {
            T result = target.getConstructor().newInstance();
            BeanUtils.copyProperties(source, result, ignoreProperties);
            return result;
        } catch ( InstantiationException
                | IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
            LOGGER.error(e.getMessage());
            throw new EasyException("erro.converter");
        }
    }

    public static <T> T converterToDTO(Object source, Class<T> target) {
        return converterToDTO(source, target, "");
    }

    public static <T> T deepConvertToDTO(Object source, Class<T> target) {
        return MAPPER.map(source, target);
    }
}

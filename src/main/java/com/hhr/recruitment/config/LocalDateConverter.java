package com.hhr.recruitment.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by sharaf on 12/6/17.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime date) {
        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date value) {
        return null;
    }
}
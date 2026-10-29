package org.abes.hrmsdatabase.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Converter
public class LocalDateConverter
        implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate date) {
        return date == null ? null : date.toString();
    }

    @Override
    public LocalDate convertToEntityAttribute(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        value = value.trim();

        // Support old timestamp values stored in milliseconds.
        if (value.matches("\\d{13}")) {
            return Instant.ofEpochMilli(Long.parseLong(value))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        // Also support dates containing a time component.
        return LocalDate.parse(value.substring(0, 10));
    }
}
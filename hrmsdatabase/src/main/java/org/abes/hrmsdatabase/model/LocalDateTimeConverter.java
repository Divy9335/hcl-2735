package org.abes.hrmsdatabase.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime value) {
        return value == null ? null : value.toString();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        value = value.trim();

        // Support old timestamp values stored in milliseconds.
        if (value.matches("\\d{13}")) {
            return Instant.ofEpochMilli(Long.parseLong(value))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }

        // Accept standard SQLite-style date-time strings.
        return LocalDateTime.parse(value.replace(' ', 'T'));
    }
}
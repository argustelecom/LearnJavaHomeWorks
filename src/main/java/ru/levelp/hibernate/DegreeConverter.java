package ru.levelp.hibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DegreeConverter implements AttributeConverter<Degree, String> {
    public String convertToDatabaseColumn(Degree attribute) {
        return attribute.name().toLowerCase();
    }

    public Degree convertToEntityAttribute(String dbData) {
        for (Degree degree : Degree.values()) {
            if (degree.name().equalsIgnoreCase(dbData)) {
                return degree;
            }
        }

        throw new IllegalArgumentException("Unmappable");
    }
}

package com.bsuir.test.converter;

import com.bsuir.test.model.Genre;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenreConverter implements AttributeConverter<Genre, String> {
    @Override
    public String convertToDatabaseColumn(Genre genre) {
        if (genre == null)
            return null;

        switch (genre) {
            case ADVENTURE:
                return "ADVENTURE";

            case THRILLER:
                return "THRILLER";

            case WESTERN:
                return "WESTERN";

            case CRIME:
                return "CRIME";

            case SCIENCE:
                return "SCIENCE";

            case POETRY:
                return "POETRY";

            case DRAMA:
                return "DRAMA";

            case FAIRY_TAIL:
                return "FAIRY_TAIL";

            case FANTASY:
                return "FANTASY";

            case FICTION:
                return "FICTION";

            case FOLKLORE:
                return "FOLKLORE";

            default:
                throw new IllegalArgumentException(genre + " not supported.");
        }
    }

    @Override
    public Genre convertToEntityAttribute(String string) {
        if (string == null)
            return null;

        switch (string) {
            case "ADVENTURE":
                return Genre.ADVENTURE;

            case "THRILLER":
                return Genre.THRILLER;

            case "WESTERN":
                return Genre.WESTERN;

            case "CRIME":
                return Genre.CRIME;

            case "SCIENCE":
                return Genre.SCIENCE;

            case "POETRY":
                return Genre.POETRY;

            case "DRAMA":
                return Genre.DRAMA;

            case "FAIRY_TAIL":
                return Genre.FAIRY_TAIL;

            case "FANTASY":
                return Genre.FANTASY;

            case "FICTION":
                return Genre.FICTION;

            case "FOLKLORE":
                return Genre.FOLKLORE;

            default:
                throw new IllegalArgumentException(string + " not supported.");
        }
    }
}

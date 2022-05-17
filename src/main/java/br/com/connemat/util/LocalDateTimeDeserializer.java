package br.com.connemat.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    protected LocalDateTimeDeserializer() {
        super(LocalDate.class);
    }
    //TODO: FIx formato javascript de LocalDateTime
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return notEmpty(jp.getText())? LocalDateTime.parse(jp.readValueAs(String.class) , DateTimeFormatter.ISO_DATE_TIME) : null;
    }
	private boolean notEmpty(String text) {
		return text !=null && !"".equals(text.trim());
	}

}
package com.cropaccounting.krishi.api.clientapi.converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 
 * @author wahid
 * @since 02 Nov 2017
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
	// sample - 2017-06-17T01:43:43.000Z
	private static final String DTF = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

	@Override
	public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
		try {
			return LocalDateTime.parse(arg0.getText(), DateTimeFormatter.ofPattern(DTF));
		} catch (DateTimeParseException ex) {
			return null;
		}
	}
}

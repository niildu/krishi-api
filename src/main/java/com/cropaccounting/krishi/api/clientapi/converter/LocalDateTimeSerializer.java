package com.cropaccounting.krishi.api.clientapi.converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author wahid
 *
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
	private static final String DTF = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(DateTimeFormatter.ofPattern(DTF).format(value));
	}
}

package com.cropaccounting.krishi.api.clientapi;

import static java.lang.String.format;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

//import org.slf4j.LoggerFactory;

import com.cropaccounting.krishi.api.clientapi.model.Blocks;
import com.cropaccounting.krishi.api.clientapi.model.Crops;
import com.cropaccounting.krishi.api.clientapi.model.Varieties;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import feign.Feign;
import feign.Headers;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 * 
 * @author Wahid Anwar
 * @since 06 Oct 2018
 */
@Headers({ "Content-Type: application/json", "Accept: application/json" })
public interface KrishiAPI {
	/*
	 * http://107.170.4.9:3030/api/blocks?limit=1
	 * &page=1
	 * &region_id=6586
	 * &district_id=1081
	 * &upazila_id=1123
	 * &search_term=রামকৃষ্ণপুর
	 */
	@RequestLine("GET /blocks?limit={limit}&page={page}&region_id={region_id}&district_id={district_id}&upazila_id={upazila_id}")
	Blocks searchBlocks(@Param("type") String type,
			@Param("page") String page, 
			@Param("region_id") String region_id,
			@Param("district_id") String district_id,
			@Param("upazila_id") String upazila_id);
	
	@RequestLine("GET /blocks")
	Blocks getBlocks();
	
	@RequestLine("GET /crops")
	Crops getCrops();
	
	@RequestLine("GET /varieties")
	Varieties getVarieities();
	
	static KrishiAPI connect(String url, Locale locale) {
		String uri = url;

		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);

		return Feign.builder().client(new ApacheHttpClient()).encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper)).errorDecoder(new Status500Decoder()).logger(new Slf4jLogger())
				.logLevel(Logger.Level.FULL)
				.requestInterceptor(
						new ApiKeyRequestInterceptor(uri, locale))
				.target(KrishiAPI.class, uri);
	}

	static class Status500Decoder implements ErrorDecoder {
//		private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

//		@Override
		public Exception decode(String methodKey, Response response) {
			if (response.status() == 500)
				return new ErrorDecoder.Default().decode(methodKey, response);
			String message = "";// format("status %s reading %s", response.status(), methodKey);
			Object body = null;
			String errorStatus = Integer.toString(response.status());
			if (response.body() != null) {
				try {
					body = Util.toString(response.body().asReader());
				} catch (IOException ignored) { // NOPMD
//					logger.debug(ignored.getMessage());
				}
			}
			/*
			 * TO DO NEED TO PARSE FOR SPECIFIC ERROR CODE
			 */
			throw new ApiException(response.status(), message, body, errorStatus);
		}
	}
}

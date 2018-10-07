package com.cropaccounting.krishi.api.clientapi;

import java.util.Locale;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author wahid
 * @since 12 Dec 2017
 */
public class ApiKeyRequestInterceptor implements RequestInterceptor {
	public static final Locale DEFAULT_LOCALE = Locale.US;

	private final String uri;
	private final Locale locale;

	public ApiKeyRequestInterceptor(String uri, Locale locale) {
		if (uri == null)
			throw new IllegalArgumentException("Required authentication fields can't be null");
		this.uri = uri;
		this.locale = locale;
	}
	
	@Override
	public void apply(RequestTemplate template) {
//		template.header("user", appKey);
//		template.header("X-FareHarbor-API-User", userKey);
		if (locale != null)
			template.header("Accept-Language", locale.toString());
	}
}
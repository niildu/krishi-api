package com.cropaccounting.krishi.api.clientapi;

import feign.FeignException;

/**
 * 
 * @author wahid
 * @since 02 Nov 2017
 */
public class ApiException extends FeignException {
	
	private static final long serialVersionUID = -1394731440866207994L;
	private final transient Object body;
	private final String errorCode;

	public ApiException(int status, String message, Object body, String errorCode) {
		super(status, message);
		this.body = body;
		this.errorCode = errorCode;
	}

	public Object body() {
		return body;
	}

	public String errorCode() {
		return errorCode;
	}
}

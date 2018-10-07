package com.cropaccounting.krishi.api.clientapi.model;

import lombok.Data;

@Data
public class AbstractListResponse {
	private boolean success;
	private int total;
	private int limit;
	private int skip;
	private int page;
	private String message;
}

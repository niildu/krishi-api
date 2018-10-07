package com.cropaccounting.krishi.api.clientapi.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Crops extends AbstractListResponse {
	private List<Crop> data;
}

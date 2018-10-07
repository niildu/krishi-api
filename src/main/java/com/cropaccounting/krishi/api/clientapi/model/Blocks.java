package com.cropaccounting.krishi.api.clientapi.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Blocks extends AbstractListResponse {
	private List<Block> data;
}

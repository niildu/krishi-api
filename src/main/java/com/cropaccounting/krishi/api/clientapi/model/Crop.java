package com.cropaccounting.krishi.api.clientapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Crop extends AbstractModel {
	 private int id;
	 private String name;
	 private String scientific_name;
	 private String type;
	 private String image;
}

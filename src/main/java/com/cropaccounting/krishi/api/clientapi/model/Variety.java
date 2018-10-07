package com.cropaccounting.krishi.api.clientapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Variety extends AbstractModel {
	private int id;
	private String name;
	private int crop_id;
	private String image;
	private String released_by;
	private int series_no;
	private String local_name;
	private String production_with_irrigation;
	private String production_without_irrigation;
	private String life_time;
}

package com.cropaccounting.krishi.api.clientapi.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Block {
	private int id;
	private String name;
	private int user_id;
	private int region_id;
	private int division_id;
	private int district_id;
	private int upazila_id;
	private String union_name;
	private int union_id;
	private int no;
	private int supervisor_id;
	private String duty_type;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String map_img;
}

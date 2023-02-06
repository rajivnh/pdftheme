package com.citi.dcm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
	private String name;
	
	private String price;
	
	private String description;
}

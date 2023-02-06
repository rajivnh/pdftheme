package com.citi.dcm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	private String name;
	
	private String email;
}

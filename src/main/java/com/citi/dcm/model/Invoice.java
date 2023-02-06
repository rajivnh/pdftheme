package com.citi.dcm.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {
	private String id;
	
	private String createdDate;
	
	private String dueDate;
	
	private String paymentMethod;
	
	private String checkNo;
	
	private Customer customer;
	
	private List<Item> items;
}

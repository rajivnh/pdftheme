package com.citi.dcm;

import java.util.Arrays;
import java.util.List;

import com.citi.dcm.core.HtmlTemplateRenderer;
import com.citi.dcm.core.HtmlToPdfConvertor;
import com.citi.dcm.model.Customer;
import com.citi.dcm.model.Invoice;
import com.citi.dcm.model.Item;

public class Runner {
	
	public static void main(String[] args) throws Exception {
		Customer customer = Customer.builder()
				.name("John Doe")
				.email("johndoe@msn.com")
				.build();
		
		List<Item> items = Arrays.asList(
				Item.builder().name("Website design").price("$300").build(),
				Item.builder().name("Hosting (3 months)").price("$75").build(),
				Item.builder().name("Domain name (1 year)").price("$10").build()
			);
		
		Invoice invoice = Invoice.builder()
				.id("126")
				.createdDate("January 1, 2015")
				.dueDate("February 1, 2015")
				.checkNo("27953") 
				.items(items)
				.customer(customer)
				.build();
		
		String html = new HtmlTemplateRenderer().apply("template.html", invoice);
		
		new HtmlToPdfConvertor().convert(html, "invoice.pdf");
	}
}

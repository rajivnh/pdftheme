package com.citi.dcm.core;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class HtmlTemplateRenderer {

	public String apply(String templateFile, Object model) throws IOException {
		String[] tokens = templateFile.split("\\.(?=[^\\.]+$)");
		
		TemplateLoader loader = new ClassPathTemplateLoader("/templates", "." + tokens[1]);
		
		Handlebars handlebars = new Handlebars(loader);
		
		handlebars.registerHelper("eq", ConditionalHelpers.eq);
		
		Template template = handlebars.compile(tokens[0]);
		
		return template.apply(model);
	}
}

package com.citi.dcm.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.springframework.util.ResourceUtils;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class HtmlToPdfConvertor {
	private org.w3c.dom.Document createWellFormedHtml(String html) throws IOException {
		Document document = Jsoup.parse(html, "UTF-8");
		
		document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);

		return new W3CDom().fromJsoup(document);
	}

	public void convert(String html, String outputPdf) throws IOException {	
		org.w3c.dom.Document document = createWellFormedHtml(html);
		
		System.out.println(ResourceUtils.getFile("classpath:templates/") + "/" + outputPdf);
		
		OutputStream os = new FileOutputStream(ResourceUtils.getFile("classpath:templates/") + "/" + outputPdf);
		
		PdfRendererBuilder builder = new PdfRendererBuilder();
		
		builder.withUri(outputPdf);
		builder.toStream(os);
		builder.useFont(ResourceUtils.getFile("classpath:templates/Montserrat-Regular.ttf"), "Montserrat");
		builder.withW3cDocument(document, "file://" + ResourceUtils.getFile("classpath:templates").toURI().getPath());
		
		builder.run();
		
		os.close();
	}
}

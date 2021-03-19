package com.olgamelnichenko.service;

import java.time.LocalDate;
import org.springframework.web.client.RestTemplate;
import com.olgamelnichenko.model.News;
import com.olgamelnichenko.property.reader.PropertyReader;

public class NewsService {
	
	/*
	 * getAPI key
	 */
	private String baseUrl;
	private final String API_KEY;
	private RestTemplate restTemplate = new RestTemplate();
	
	public NewsService (String baseUrl, PropertyReader reader) {
		this.baseUrl = baseUrl;
		this.API_KEY = reader.getPropertyValue();
	}
	
	public News getNews() {
		LocalDate today = LocalDate.now();
		String localDate = today.toString();
		News news = restTemplate.getForObject(baseUrl + "v2/everything?q=ohio+columbus&apiKey=" + API_KEY + "&to=" + localDate + "&from=" + localDate, News.class);
		return news;
	}
}

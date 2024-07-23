package com.alejandracenteno.prueba.serviceshttp;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alejandracenteno.prueba.dao.RegionDao;
import com.alejandracenteno.prueba.entity.*;

public class RegionServiceHttp {

	public Region consultarRegion(String region) {
		
		Region response = new Region();
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/region/busqueda/"+region);
			
			ResponseEntity<Region> result = restTemplate.postForEntity(uri, null, Region.class);
			
			response = result.getBody();
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	public String ingresarRegion(RegionDao request) {
		String response = "";
		
		try {
			
			@SuppressWarnings("deprecation")
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
			RestTemplate restTemplate = new RestTemplate(factory);
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/region");
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<?> entity = new HttpEntity<>(null, headers);
			response = restTemplate.postForEntity(uri, request, null);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return response;
	}
	
}

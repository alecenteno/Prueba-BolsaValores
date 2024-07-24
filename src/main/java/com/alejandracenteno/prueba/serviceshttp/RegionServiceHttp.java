package com.alejandracenteno.prueba.serviceshttp;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alejandracenteno.prueba.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RegionServiceHttp {

	public Region consultarRegion(String region) {

		Region response = new Region();

		try {
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/region/busqueda/" + region);

			ResponseEntity<Region> result = restTemplate.getForEntity(uri, Region.class);

			response = result.getBody();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}
	
	public State consultarEstado(String estado) {

		State response = new State();
		String state = estado.replace(" ", "_");
		try {
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/state/busqueda/" + state);
			ResponseEntity<State> result = restTemplate.getForEntity(uri, State.class);

			response = result.getBody();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response;

	}
	
	public County consultarCountyByName(String conty) {

		System.out.println("Condado " + conty);
		County response = new County();
		try {
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/county/busqueda/" + conty);
			ResponseEntity<County> result = restTemplate.getForEntity(uri, County.class);

			response = result.getBody();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response;

	}

	
	public String ingresarRegion(Region request) {
		ResponseEntity<String> response = null;
		ObjectMapper obj = new ObjectMapper();
		String json = "";
		String jsonResponse = "";
		try {
			// Configuracion de encabezado y url a usar
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(factory);
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/region");
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);

			// se pasa la entidad region a un objeto json
			json = obj.writeValueAsString(request);
			System.out.println("Json a insertar " + json);

			// se escribe todo el objeto de peticion
			HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

			response = restTemplate.postForEntity(uri, requestEntity, String.class);

			if (response.getStatusCode().value() == 201) {

				jsonResponse = "{\"Codigo\":201,\"Descripcion\":\"Registro creado Correctamente\"}";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return jsonResponse;
	}

	
	public String insertarEstado(State request) {
		ResponseEntity<String> response = null;
		ObjectMapper obj = new ObjectMapper();
		String json = "";
		String jsonResponse = "";
		try {
			// Configuracion de encabezado y url a usar
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(factory);
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/state");
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);

			// se pasa la entidad region a un objeto json
			json = obj.writeValueAsString(request);
			System.out.println("Json a insertar " + json);

			// se escribe todo el objeto de peticion
			HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

			response = restTemplate.postForEntity(uri, requestEntity, String.class);

			if (response.getStatusCode().value() == 201) {

				jsonResponse = "{\"Codigo\":201,\"Descripcion\":\"Registro creado Correctamente\"}";
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return jsonResponse;
	}
	
	public String insertarCondado(County request) {
		ResponseEntity<String> response = null;
		ObjectMapper obj = new ObjectMapper();
		String json = "";
		String jsonResponse = "";
		try {
			// Configuracion de encabezado y url a usar
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(factory);
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/county");
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);

			// se pasa la entidad region a un objeto json
			json = obj.writeValueAsString(request);
			System.out.println("Json a insertar " + json);

			// se escribe todo el objeto de peticion
			HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

			response = restTemplate.postForEntity(uri, requestEntity, String.class);

			if (response.getStatusCode().value() == 201) {

				jsonResponse = "{\"Codigo\":201,\"Descripcion\":\"Registro creado Correctamente\"}";
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return jsonResponse;
	}

	public String insertarPlaceName(PlaceName request) {
		ResponseEntity<String> response = null;
		ObjectMapper obj = new ObjectMapper();
		String json = "";
		String jsonResponse = "";
		try {
			// Configuracion de encabezado y url a usar
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(factory);
			URI uri = new URI("http://localhost:8080/api/prueba/bolsa-valores/placename");
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);

			// se pasa la entidad region a un objeto json
			json = obj.writeValueAsString(request);
			System.out.println("Json a insertar " + json);

			// se escribe todo el objeto de peticion
			HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

			response = restTemplate.postForEntity(uri, requestEntity, String.class);

			if (response.getStatusCode().value() == 201) {

				jsonResponse = "{\"Codigo\":201,\"Descripcion\":\"Registro creado Correctamente\"}";
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return jsonResponse;
	}
	
}

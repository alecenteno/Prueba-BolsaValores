package com.alejandracenteno.prueba.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import com.alejandracenteno.prueba.dao.*;
import com.alejandracenteno.prueba.entity.County;
import com.alejandracenteno.prueba.entity.PlaceName;
import com.alejandracenteno.prueba.entity.Region;
import com.alejandracenteno.prueba.entity.State;
import com.alejandracenteno.prueba.serviceshttp.RegionServiceHttp;

public class FileUploadReader {

	public void readerFile(String csvFile) {
		BufferedReader br = null;
		String line = "";

		// Se define separador ","
		String cvsSplitBy = ";";
		System.out.println("Separador " + cvsSplitBy);

		try {
			br = new BufferedReader(new FileReader(csvFile));
			List<ArchivoDao> archivo = new ArrayList<>();

			while ((line = br.readLine()) != null) {
				String[] datos = line.split(cvsSplitBy);

				ArchivoDao d = new ArchivoDao();
				d.setIndex(datos[0]);
				d.setPostalCode(datos[1]);
				d.setPlaceName(datos[2]);
				d.setState(datos[3]);
				d.setStateAbbreviation(datos[4]);
				d.setCounty(datos[5]);
				d.setRegion(datos[6]);
				d.setPhoneAreaCode(datos[7]);
				archivo.add(d);
			}

			insertarRegiones(archivo);
			insertarEstados(archivo);
			insertarCondados(archivo);
			insertarPlaceName(archivo);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertarRegiones(List<ArchivoDao> archivo) {
		List<Region> list = new ArrayList<>();
		list = obtenerRegiones(archivo);
		RegionServiceHttp servicio = new RegionServiceHttp();
		
		for (int i = 0; i < list.size(); i++) {
			servicio.ingresarRegion(list.get(i));
		}
	}

	public void insertarEstados(List<ArchivoDao> archivo) {
		List<State> list = new ArrayList<>();

		list = obtenerListEstados(archivo);
		RegionServiceHttp servicio = new RegionServiceHttp();

		for (int i = 0; i < list.size(); i++) {
			servicio.insertarEstado(list.get(i));
		}

	}

	public void insertarPlaceName(List<ArchivoDao> archivo) {
		List<PlaceName> list = new ArrayList<>();

		list = obtenerListPlaceName(archivo);
		RegionServiceHttp servicio = new RegionServiceHttp();
		for (int i = 0; i < list.size(); i++) {
			servicio.insertarPlaceName(list.get(i));
		}

	}

	public void insertarCondados(List<ArchivoDao> archivo) {
		List<County> list = new ArrayList<>();

		list = obtenerListCondados(archivo);
		RegionServiceHttp servicio = new RegionServiceHttp();

		for (int i = 0; i < list.size(); i++) {
			servicio.insertarCondado(list.get(i));
		}
	}

	private List<Region> obtenerRegiones(List<ArchivoDao> lista) {
		List<Region> listaFiltrada = new ArrayList<>();
		Region region = new Region();
		System.out.println("ingresa lista a obtener regiones " + lista.size());
		try {

			for (int i = 0; i < lista.size(); i++) {
				region.setName(lista.get(i).getRegion());

				if (listaFiltrada.isEmpty() && i == 0) {

					listaFiltrada.add(region);

				} else if (!listaFiltrada.contains(region)) {
					listaFiltrada.add(region);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaFiltrada;
	}

	private List<State> obtenerListEstados(List<ArchivoDao> lista) {
		List<State> estadosList = new ArrayList<>();
		HashMap<Integer, String> mapaEstados = new HashMap<>();
		HashMap<String, String> mapaRegion = new HashMap<>();
		String estado = "";
		
		for (int i = 1; i < lista.size(); i++) {
			estado = (lista.get(i).getState());
			
			if (! mapaEstados.containsValue(estado)) {
				mapaEstados.put(i, estado);
				mapaRegion.put(String.valueOf(i), lista.get(i).getRegion());
			}	
		}
		
		for(int clave : mapaEstados.keySet()) {
			State s = new State();
			s.setName(lista.get(clave).getState());
			s.setAbbreviation(lista.get(clave).getStateAbbreviation());
			s.setPhoneareacode(Integer.valueOf(lista.get(clave).getPhoneAreaCode()));
			s.setRegionID(obteneridRegion(lista.get(clave).getRegion()).getIdregion());
			estadosList.add(s);
		}

		System.out.println("listado estados " + estadosList.size());
		return estadosList;

	}

	private List<County> obtenerListCondados(List<ArchivoDao> lista) {
		List<County> condadoList = new ArrayList<>();
		String condado = "";

		HashMap<String, String> mapaCounty = new HashMap<>();

		for (int i = 1; i < lista.size(); i++) {

			condado = lista.get(i).getCounty();
			if (!mapaCounty.containsValue(condado)) {
				mapaCounty.put(String.valueOf(i), condado);
			}
		}

		for (String clave : mapaCounty.keySet()) {
			County c = new County();
			c.setName(mapaCounty.get(clave));
			int estado = obtenerEstadoCondado(lista.get(Integer.valueOf(clave)).getState()).getIdstate();
			c.setState(estado);
			condadoList.add(c);
		}

		System.out.println("listado Condados " + condadoList.size());
		return condadoList;

	}

	private List<PlaceName> obtenerListPlaceName(List<ArchivoDao> lista) {
		List<PlaceName> placeNameList = new ArrayList<>();
		String placeName = "";

		HashMap<String, String> mapaPlaceName = new HashMap<>();
		placeName = lista.get(1).getPlaceName();
		// mapa.put("estado", lista.get(1).getState());

		for (int i = 1; i < lista.size(); i++) {

			placeName = lista.get(i).getPlaceName();
			if (!mapaPlaceName.containsValue(placeName)) {
				mapaPlaceName.put(String.valueOf(i), placeName);
				//mapaCounty.put(String.valueOf(i), lista.get(i).getCounty());
			}
		}

		for (String clave : mapaPlaceName.keySet()) {
			PlaceName pn = new PlaceName();
			pn.setName(mapaPlaceName.get(clave));
			int countyId = obtenerIdCounty(lista.get(Integer.valueOf(clave)).getCounty());
			pn.setCountyid(countyId);
			pn.setPostalcode(lista.get(Integer.valueOf(clave)).getPostalCode());
			placeNameList.add(pn);
		}

		System.out.println("listado Placename " + placeNameList.size());
		return placeNameList;

	}

	private Region obteneridRegion(String region) {

		RegionServiceHttp servicio = new RegionServiceHttp();
		Region respuesta = null;

		respuesta = servicio.consultarRegion(region);

		return respuesta;
	}

	private State obtenerEstadoCondado(String estado) {

		RegionServiceHttp servicio = new RegionServiceHttp();
		State respuesta = new State();

		respuesta = servicio.consultarEstado(estado);

		return respuesta;
	}

	private int obtenerIdCounty(String county) {
		RegionServiceHttp servicio = new RegionServiceHttp();
		County respuesta = new County();
		respuesta = servicio.consultarCountyByName(county);
		return respuesta.getIdcounty();
	}

}

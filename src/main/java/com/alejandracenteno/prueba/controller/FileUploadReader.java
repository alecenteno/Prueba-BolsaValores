package com.alejandracenteno.prueba.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alejandracenteno.prueba.dao.*;
import com.alejandracenteno.prueba.serviceshttp.RegionServiceHttp;

public class FileUploadReader {
	
	public void readerFile(String csv) {
		String csvFile = "PruebaBV/TablaPrueba.csv";
		BufferedReader br = null;
		String line = "";
		
		//Se define separador ","
		String cvsSplitBy = ";";
		
		try {
			
		    br = new BufferedReader(new FileReader(csvFile));
		    while ((line = br.readLine()) != null) {
		        String[] datos = line.split(cvsSplitBy);
		        List<ArchivoDao> archivo = new ArrayList<>();
		        ArchivoDao d = new ArchivoDao();
		        List<RegionDao> regionDao = new ArrayList<>();
		        
		        d.setIndex(datos[0]);
		        d.setPostalCode(datos[1]);
		        d.setPlaceName(datos[2]);
		        d.setState(datos[3]);
		        d.setStateAbbreviation(datos[4]);
		        d.setCounty(datos[5]);
		        d.setRegion(datos[6]);
		        d.setPhoneAreaCode(datos[7]);
		        
		        archivo.add(d);
	
		        regionDao = obtenerRegiones(archivo);
		        
		        for(int i=0; i<=regionDao.size(); i++) {
		        	RegionServiceHttp rshttp = new RegionServiceHttp();
		        	rshttp.ingresarRegion(regionDao.get(i));
		        }
		        
		        //Imprime datos.
		       System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
		    }
		    
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
	
	
	private List<RegionDao> obtenerRegiones (List<ArchivoDao> lista){
		List<RegionDao> listaFiltrada = new ArrayList<>();
		RegionDao region = new RegionDao();
		try {
			
			for (int i = 0; i < lista.size(); i++) {
				region.setRegion(lista.get(i).getRegion());
				
				if (listaFiltrada.isEmpty() && i == 0) {
					
					listaFiltrada.add(region);
					
				}else if ( !listaFiltrada.contains(region)) {
						listaFiltrada.add(region);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaFiltrada;
	}
	
	
}

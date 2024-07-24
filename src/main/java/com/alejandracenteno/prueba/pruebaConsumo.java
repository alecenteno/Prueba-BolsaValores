package com.alejandracenteno.prueba;


import com.alejandracenteno.prueba.controller.FileUploadReader;
import com.alejandracenteno.prueba.entity.County;
import com.alejandracenteno.prueba.serviceshttp.RegionServiceHttp;

public class pruebaConsumo {

	public static void main(String[] args) {
		System.out.println("inicia lectura de mensaje ");
		
		FileUploadReader fileUp = new FileUploadReader();
		
		fileUp.readerFile("D:\\documentos\\PruebaBV\\TablaPrueba.csv");
		
		RegionServiceHttp s = new RegionServiceHttp();
		County c = s.consultarCountyByName("Hampshire");
		
		System.out.println(c.getIdcounty());
		System.out.println(c.getName());
	}
	
}

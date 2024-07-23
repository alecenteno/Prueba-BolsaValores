package com.alejandracenteno.prueba;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.alejandracenteno.prueba.serviceshttp.RegionServiceHttp;

@SpringBootTest
public class pruebaConsumo {

	public static void main(String[] args) {
		RegionServiceHttp rsh = new RegionServiceHttp();
	rsh.consultarRegion("prueba123");
	System.out.println(rsh);
	}
	
}

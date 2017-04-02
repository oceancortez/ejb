package org.oc.bean.ws;

import javax.xml.ws.Endpoint;

public class PublicaGaragemWS {

	public static void main(String[] args) {

		GaragemWS service = new GaragemWS();		
		final String url = "http://localhost:8080/garagemws";
		
		System.out.println("Publicando o service garagemws " + url +"?wsdl");
		Endpoint.publish(url, service);
		
	}

}

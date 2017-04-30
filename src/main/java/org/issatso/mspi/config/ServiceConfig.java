package org.issatso.mspi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class ServiceConfig {
	@Bean
	public SimpleJaxWsServiceExporter soapExporter() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8096/devoirSoap");
		return exporter;
	}
}

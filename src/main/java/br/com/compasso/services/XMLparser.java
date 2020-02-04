package br.com.compasso.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public interface XMLparser<E> {
	
   default <T> void serializaXML(T obj, String filename) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(filename),obj);
	}
	
    E desserealizaXML()throws IOException;
}

package br.com.compasso.DAO;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.model.Cliente;
import br.com.compasso.services.XMLparser;
import br.com.compasso.services.cadastros.CadastroCliente;
import br.com.compasso.utils.Filenames;

public class ClienteDAO implements XMLparser<Set<Cliente>>{

	private ObjectMapper mapper = new XmlMapper();
	private CadastroCliente value;
	
	@Override
	public Set<Cliente> desserealizaXML() throws IOException {
		 File file = new File(Filenames.CLIENTES);
		 this.value = this.mapper.readValue(file, CadastroCliente.class);
		 return this.value.getClientesCadastrados();
	}

	
}

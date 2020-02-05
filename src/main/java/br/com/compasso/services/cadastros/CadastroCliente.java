package br.com.compasso.services.cadastros;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.DAO.ClienteDAO;
import br.com.compasso.model.Cliente;
import br.com.compasso.services.ValidaCPF;
import br.com.compasso.utils.Filenames;

@JacksonXmlRootElement(localName = "CadastroCliente")
public class CadastroCliente implements CadastrarItem<Cliente>{
	@JacksonXmlProperty(localName = "cliente")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<Cliente> clientesCadastrados = new HashSet<Cliente>();

	private ClienteDAO clienteDao = new ClienteDAO();
	private ValidaCPF validador = new ValidaCPF();
	
	
	@Override
	public void cadastra(Cliente cliente) throws IOException{
		
			if (new File(Filenames.CLIENTES).exists()) {
			this.clientesCadastrados = new HashSet<Cliente>(clienteDao.desserealizaXML());
			}
		
			
			validaCpfCliente(cliente.getCpf());

			if (clientesCadastrados.add(cliente)) {//add cliente
				persisteClientes();
				System.out.println("cliente cadastrado");
			} else {
				System.out.println("ja existe outro cliente com o mesmo cpf");
			}
		
	}

	private void validaCpfCliente(String cpf) {
		try {
			validador.validarDocumento(cpf);
			
		} catch (Exception e) {
			throw new RuntimeException("O cpf não é valido");
		}
	}

	public void persisteClientes() throws IOException {
		clienteDao.serializaXML(this, Filenames.CLIENTES);
	}

	public Set<Cliente> getClientesCadastrados() throws IOException {
		return Collections.unmodifiableSet(clientesCadastrados);
	}

	
	
		
	


}

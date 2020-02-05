package br.com.compasso.services.cadastros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.DAO.PedidoDAO;
import br.com.compasso.model.Pedido;
import br.com.compasso.utils.Filenames;

@JacksonXmlRootElement(localName = "CadastroPedido")
public class CadastroPedido implements CadastrarItem<Pedido>{
	
	@JacksonXmlProperty(localName = "pedido")
	@JacksonXmlElementWrapper(useWrapping = false)
	List<Pedido> pedidoscadastrados = new ArrayList<Pedido>();
	
	PedidoDAO pedidoDao = new PedidoDAO();
	@Override
	public void cadastra(Pedido pedido) throws IOException {
		if (new File(Filenames.PEDIDOS).exists()) {
			this.pedidoscadastrados = new ArrayList<Pedido>(pedidoDao.desserealizaXML());
		}
			pedidoscadastrados.add(pedido);
			pedidoDao.serializaXML(this, Filenames.PEDIDOS);
			System.out.println("pedido realizado\n");
	}
	public List<Pedido> getPedidoscadastrados() {
		return Collections.unmodifiableList(pedidoscadastrados);
	}
	
	
}

package br.com.compasso.DAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.model.Pedido;
import br.com.compasso.services.XMLparser;
import br.com.compasso.services.cadastros.CadastroPedido;
import br.com.compasso.utils.Filenames;

public class PedidoDAO implements XMLparser<List<Pedido>> {

	private CadastroPedido pedido;
	private ObjectMapper mapper = new XmlMapper();

	@Override
	public List<Pedido> desserealizaXML() throws IOException {
		 File file = new File(Filenames.PEDIDOS);
		 this.pedido = this.mapper.readValue(file, CadastroPedido.class);
		 return this.pedido.getPedidoscadastrados();
	}

}

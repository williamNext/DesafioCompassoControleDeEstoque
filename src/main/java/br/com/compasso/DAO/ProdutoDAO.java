package br.com.compasso.DAO;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.model.Produto;
import br.com.compasso.services.XMLparser;
import br.com.compasso.services.cadastros.CadastroProduto;
import br.com.compasso.utils.Filenames;
public class ProdutoDAO implements XMLparser<Set<Produto>>{
	
	private ObjectMapper mapper = new XmlMapper();
	private CadastroProduto produto;


	@Override
	public Set<Produto> desserealizaXML() throws IOException {
		 File file = new File(Filenames.PRODUTOS);
		 this.produto = this.mapper.readValue(file, CadastroProduto.class);
		 return this.produto.getProdutos();
	}
	
}

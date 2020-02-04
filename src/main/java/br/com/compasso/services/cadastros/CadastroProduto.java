package br.com.compasso.services.cadastros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.DAO.ProdutoDAO;
import br.com.compasso.model.Produto;
import br.com.compasso.utils.Filenames;


@JacksonXmlRootElement(localName = "CadastroProduto")
public class CadastroProduto implements CadastrarItem<Produto>{
	
	@JacksonXmlProperty(localName = "produto")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<Produto> produtos  = new HashSet<Produto>();
	
	ProdutoDAO produtoDao = new ProdutoDAO();
	private final String filename = "Produtos.xml";
	
	
	@Override
	public void cadastra(Produto produto) throws IOException {
		
			if (new File(filename).exists()) {
				this.produtos = new HashSet<Produto>(produtoDao.desserealizaXML());
			}
		
		
			if (produtos.add(produto)) { 
				produtoDao.serializaXML(this, Filenames.PRODUTOS);
			} else {
				System.out.println("Produto ja cadastrado");
			}

		
		
	}
	
	
	public Set<Produto> getProdutos() throws IOException {
		return Collections.unmodifiableSet(produtos);
	}
	
	

}

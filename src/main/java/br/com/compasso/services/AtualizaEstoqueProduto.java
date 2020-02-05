package br.com.compasso.services;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.DAO.ProdutoDAO;
import br.com.compasso.model.Produto;
import br.com.compasso.utils.Filenames;
@JacksonXmlRootElement(localName = "CadastroProduto")
public class AtualizaEstoqueProduto{
	
	@JacksonXmlProperty(localName = "produto")
	@JacksonXmlElementWrapper(useWrapping = false)
	private HashSet<Produto> produtos;
	private ProdutoDAO produtoDao = new ProdutoDAO();

	public void deleteProduto(Produto produto) {
		try {
			if (new File(Filenames.PRODUTOS).exists()) {
				this.produtos = new HashSet<Produto>(produtoDao.desserealizaXML());
				this.produtos.remove(produto);
				produtoDao.serializaXML(this, Filenames.PRODUTOS);
			}
		} catch (IOException e1) {
			throw new RuntimeException("falha na atualização do estoque");
		}
	}

	
	

}
